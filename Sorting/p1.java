package Sorting;

public class p1 {
    public static void main(String[] args) {
        int a[] = { 20, 26, 88, 12 };

        // travel in arr

        for (int i = 0; i < a.length - 1; i++) {
            // swap element
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
