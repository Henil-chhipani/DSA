package Arrays;

public class p2 {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4 };
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println(max);
    }
}
