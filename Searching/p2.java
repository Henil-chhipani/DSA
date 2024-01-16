package Searching;

public class p2 {
    public static void main(String[] args) {
        int a[] = { 20, 26, 88, 13, 99 };
        int x = 20, temp = -1;
        int l = 0, r = a.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (a[m] == x)
                temp = m;

            if (a[m] < x)
                l = m + 1;

            else
                r = m - 1;
        }

        if (temp != -1) {
            System.out.println("num at " + temp);
        } else {
            System.out.println("not available");
        }

    }
}
