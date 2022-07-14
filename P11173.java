import java.io.FileInputStream;

// 11173  Grey Code
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
        sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int s = sc.nextInt();

            int lastBit = 0;
            int output = 0;
            for (int j = 1; j <= a; j++) {
                int pos = a - j;
                int val = (s >> pos) & 1;
                output <<= 1;
                output |= lastBit ^ val;
                lastBit = val;
            }
            System.out.println(Integer.toBinaryString(output));
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
