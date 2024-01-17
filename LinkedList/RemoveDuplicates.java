package LinkedList;

import java.util.HashSet;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicates {
    private Node head;

    public RemoveDuplicates() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        HashSet<Integer> uniqueElements = new HashSet<>();
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (uniqueElements.contains(current.data)) {
                // Duplicate found, remove the current node
                previous.next = current.next;
            } else {
                uniqueElements.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveDuplicates linkedList = new RemoveDuplicates();

        // Inserting elements into the linked list
        linkedList.insert(3);
        linkedList.insert(1);
        linkedList.insert(3);
        linkedList.insert(5);
        linkedList.insert(1);
        linkedList.insert(7);
        linkedList.insert(5);

        System.out.println("Original Linked List:");
        linkedList.display();

        // Removing duplicates
        linkedList.removeDuplicates();

        System.out.println("Linked List after removing duplicates:");
        linkedList.display();
    }
}
