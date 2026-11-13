import java.util.Scanner;

public class Fibonacci {
    static long calls = 0;

    static long fibIterative(int n) {
        long a = 0, b = 1;
        int steps = 0;
        System.out.print("Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            long c = a + b;
            a = b;
            b = c;
            steps++;
        }
        System.out.println();
        System.out.println("Non-recursive steps = " + steps + "  -> Time O(n), Space O(1)");
        return a;
    }

    static long fibRecursive(int n) {
        calls++;
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        long v1 = fibIterative(n);
        System.out.println("Non-recursive F(" + n + ") = " + v1);

        if (n <= 30) {
            long v2 = fibRecursive(n);
            System.out.println("Recursive     F(" + n + ") = " + v2 + ", calls = " + calls + "  -> Time O(2^n), Space O(n)");
        } else {
            System.out.println("Recursive skipped for n > 30 (O(2^n) is too slow)");
        }
        sc.close();
    }
}
