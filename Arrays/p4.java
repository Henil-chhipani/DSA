package Arrays;

import java.util.ArrayList;

public class p4 {
    public static void main(String[] args) {
        int a[] = { 1, 1, 2, 3, 4 };
        int b[] = { 1, 5, 2, 6 };
        ArrayList<Integer> c = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    if (!c.contains(a[i])) {
                        c.add(a[i]);
                    }

                }
            }
        }
        System.out.println(c);
    }
}
