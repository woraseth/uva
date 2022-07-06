import java.io.FileInputStream;

// 10550	Combination Lock
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    int cw(int a, int b) {
        if (a >= b)
            return a - b;
        else
            return (40+a) - b;
    }

    int ccw(int a, int b) {
        return cw(b, a);
    }
    void go() throws Exception {
        //sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            if (a == 0 && b == 0 && c == 0 && d == 0) break;

            int total = 80;
            total += cw(a, b);
            total += 40;
            total += ccw(b, c);
            total += cw(c, d);

            System.out.println(total * 9);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
