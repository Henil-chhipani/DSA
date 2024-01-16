package LinkedList;

import java.util.LinkedList;

public class p4 {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(3);
        l1.add(3);
        l1.add(1);

        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l1.size(); j++) {
                if (l.get(i).equals(l1.get(j)) && !l2.contains(l.get(i))) {
                    l2.add(l.get(i));
                }
            }
        }
        System.out.println(l2);

    }
}
