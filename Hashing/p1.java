package Hashing;

import java.util.LinkedList;

class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value); // Update existing key
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null; // Key not found
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

public class p1 {
    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>();

        // Insertion
        table.put("One", 1);
        table.put("Two", 2);
        table.put("Three", 3);

        // Retrieval
        System.out.println("Value for key 'Two': " + table.get("Two"));

        // Update existing key
        table.put("Two", 22);
        System.out.println("Updated value for key 'Two': " + table.get("Two"));

        // Deletion
        table.remove("Three");
        System.out.println("Size after removal: " + table.size());
    }
}
