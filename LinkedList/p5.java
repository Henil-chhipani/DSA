package LinkedList;

import java.util.LinkedList;

public class p5 {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        LinkedList<Integer> l1 = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(2);
        l.add(1);
        l.add(2);
        l.add(2);

        for (int i = 0; i < l.size(); i++) {
            if (!l1.contains(l.get(i))) {
                l1.add(l.get(i));
            }
        }
        System.out.println(l1);
    }
}
