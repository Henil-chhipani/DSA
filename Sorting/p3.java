package Sorting;

public class p3 {
    public static void main(String[] args) {
        int a[] = { 20, 26, 88, 12 };

        for (int i = 0; i < a.length; i++) {
            int k = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > k) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = k;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
