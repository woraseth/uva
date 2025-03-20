// 10589 Area
import java.util.*;


public class Main {
    Scanner sc = new Scanner(System.in);

    double distance(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;

        return Math.sqrt(dx * dx + dy * dy);
    }

    void go() throws Exception {
        while (true) {
            int N = sc.nextInt();
            int a = sc.nextInt();
            if (N == 0 && a == 0) break;
            int count = 0;
            for (int i = 0; i < N; i++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                double d1 = distance(x, y, 0, 0);
                if (d1 > a) continue;
                double d2 = distance(x, y, 0, a);
                if (d2 > a) continue;
                double d3 = distance(x, y, a, a);
                if (d3 > a) continue;
                double d4 = distance(x, y, a, 0);
                if (d4 > a) continue;
                count++;
            }
            System.out.printf("%.5f%n", (double) count * a * a / N);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
