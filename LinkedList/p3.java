package LinkedList;

import java.util.LinkedList;

public class p3 {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        LinkedList<String> l1 = new LinkedList<>();
        l.add("one");
        l.add("two");
        l.add("three");
        int k = 0;

        for (int i = l.size() - 1; i >= 0; i--) {
            l1.add(l.get(i));
        }
        System.out.println(l1);

    }
}
