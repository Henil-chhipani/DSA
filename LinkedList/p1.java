package LinkedList;

import java.util.LinkedList;

public class p1 {

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        l.add("one");
        l.add("two");
        l.add("three");

        System.out.println(l);

        l.removeLast();
        System.out.println(l);
    }
}
