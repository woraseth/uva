import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean debug = false;
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] a;
    static int[] x;
    static int[] y;
    static double[] dp;

    static double dist(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static double rec(int sel) {    // sel is for selected
        if (sel == (1<<N) - 1) {    // complete
            return 0;
        }

        if (dp[sel] != -1) {
            return dp[sel];
        }

        double min = Double.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if ((sel & (1<<i)) != 0) continue;
            sel |= 1<<i;
            for (int j = i+1; j < N; j++) {
                if ((sel & (1<<j)) != 0) continue;
                sel |= 1<<j;
                double dist = dist(x[i], y[i], x[j], y[j]) + rec(sel);
                if (dist < min)
                    min = dist;
                sel ^= 1<<j;
            }
            sel ^= 1<<i;
        }
        dp[sel] = min;
        return dp[sel];
    }

    public static void main(String[] args) throws Exception {
//        sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
        int caseNo = 1;
        while (true) {
            N = sc.nextInt() * 2;
            if (N == 0) return;
            dp = new double[1<<N];
            Arrays.fill(dp, -1);
            a = new int[N];
            x = new int[N];
            y = new int[N];
            for (int i = 0; i < N; i++) {
                sc.next();
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }

            System.out.printf("Case %d: %.2f%n", caseNo++,  rec(0));
        }
    }
}
