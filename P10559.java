import java.io.FileInputStream;

// 10559 Blocks
// TLE   
// - ? hashmap<string,int> 1 2 2 2 3 4 4 => 1:1,2:3,3:1,4:2
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    int[] remove(int[] a, int start) {
        int x = a[start];
        int end = start;
        for (; end < a.length; end++) {
            if (x != a[end])
                break;
        }
        int[] result = new int[a.length - (end - start)];
        for (int i = 0; i < start; i++) {
            result[i] = a[i];
        }
        for (int i = end; i < a.length; i++) {
            result[start++] = a[i];
        }
        return result;
    }
    int opt(int[] a) {
        if (a.length == 0)  return 0;
        if (a.length == 1)  return 1;

        int max = Integer.MIN_VALUE;
        int x = -1;
        for (int i = 0; i < a.length; i++) {
            if (x != a[i]) {
                x = a[i];
                int[] b = remove(a, i);
                int removed = a.length - b.length;
                int score = removed*removed + opt(b);
                if (score > max) {
                    max = score;
                }
            }
        }
        return max;
    }
    void go() throws Exception {
//        sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
        int test_cases = sc.nextInt();
        for (int t = 0; t < test_cases; t++) {
            int N = sc.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }
            System.out.printf("Case %d: %d%n", t+1, opt(a));
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
