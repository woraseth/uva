import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc;
    static {
        try {
//          sc = new Scanner(System.in);
            sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    static double min = Double.MAX_VALUE;

    static int N;
    static int[] a;
    static int[] x;
    static int[] y;

    static int count;
    static boolean isIn(int x, int[] a, int N) {
        for (int i = 0; i < N; i++) {
            if (x == a[i])
                return true;
        }
        return false;
    }

    static boolean lessThan(int x, int[] a, int N) {
        for (int i = 0; i < N; i+=2) {
            if (x <= a[i])
                return true;
        }
        return false;
    }

    static double d(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return Math.sqrt(dx*dx + dy*dy);
    }
    static double distance() {
        double sum = 0;
        for (int i = 0; i < N; i += 2) {
            sum += d(x[a[i]], y[a[i]], x[a[i+1]], y[a[i+1]]);
        }
        return sum;
    }
    static void f(int d) {
        if (d == N/2) {
            double distance = distance();
            count++;
            System.out.println(Arrays.toString(a) + " " + distance);
            if (distance < min) min = distance;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isIn(i, a, d*2) || lessThan(i, a, d*2)) continue;
            a[d*2] = i;
            for (int j = i+1; j < N; j++) {
                if (isIn(j, a, d*2+1)) continue;
                a[d*2+1] = j;
                f(d+1);
            }
        }
    }

    static void permute(int k) {
        for (int i = k; i < a.length; i++) {
            int t = a[i]; a[i] = a[k]; a[k] = t;
            permute(k+1);
            t = a[i]; a[i] = a[k]; a[k] = t;

        }
        if (k == a.length - 1) {
            double distance = distance();
            if (distance < min) min = distance;
        }
    }

    public static void main2(String[] args) {
        for (int i = 0; i < N; i++) {
            a[i] = i;
         }
        permute(0);

        System.out.println(min);
    }

    public static void main(String[] args) {
        int caseNo = 1;
        while (sc.hasNext()) {
            min = Double.MAX_VALUE;
            count = 0;
            N = sc.nextInt() * 2;
            if (N == 0) return;
            a = new int[N];
            x = new int[N];
            y = new int[N];
            for (int i = 0; i < N; i++) {
                sc.next();
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            f(0);
            System.out.printf("Case %d: %.2f%n", caseNo++, min);
            System.out.println(count);
        }

    }
}
}
