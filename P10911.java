// time limit exceed
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    //static int[] x = {10,20,5,1,120,6,50, 3,6,0};
    //static int[] y = {10,10,5,1,  3,6,60,24,9,0};
    //static int[] x = {1,3,4,8};
    //static int[] y = {2,4,7,10};
    static int N;
    static int[] a;
    static int[] x;
    static int[] y;

    static boolean isIn(int x, int[] a, int N) {
        for (int i = 0; i < N; i++) {
            if (x == a[i])
                return true;
        }
        return false;
    }

    static double min = Double.MAX_VALUE;

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
//            System.out.println(Arrays.toString(a) + " " + distance);
            if (distance < min) min = distance;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isIn(i, a, d*2)) continue;
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
//            System.out.println(Arrays.toString(a));
            double distance = distance();
//            System.out.println(Arrays.toString(a) + " " + distance);
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
            N = sc.nextInt() * 2;
            if (N == 0) return;
            a = new int[N];
            x = new int[N];
            y = new int[N];
            for (int i = 0; i < N; i++) {
                sc.next();
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
                //System.out.println(x[i] + " " + y[i]);
            }
            f(0);
            System.out.printf("Case %d: %.2f%n", caseNo++, min);
        }

    }
}
