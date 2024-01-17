package DynamicPrograming;

public class p1 {

    static int[] fib(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n
                + 2]; // 1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1 */
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
            /*
             * Add the previous 2 numbers in the series
             * and store it
             */
            f[i] = f[i - 1] + f[i - 2];
        }

        return f;
    }

    public static void main(String args[]) {
        int n = 9;
        int a[] = new int[n + 2];

        a = fib(n);

        System.out.println(n + "th element " + a[n] + "\n" + (n - 1) + "th element " + a[n - 1]);
    }
}
