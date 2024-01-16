package Searching;

public class p1 {
    public static void main(String[] args) {
        int a[] = { 20, 26, 88, 12 };
        int x = 12, temp = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                temp = i;
            }
        }

        if (temp != -1) {
            System.out.println("num at " + temp);
        } else {
            System.out.println("not available");
        }

    }
}
