package LinkedList;

import java.util.LinkedList;

public class p2 {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        l.add("one");
        l.add("two");
        l.add("three");

        int n = l.size() / 2;
        System.out.println(l.get(n));
    }
}
