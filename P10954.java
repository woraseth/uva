import java.io.FileInputStream;

// 10954  Add All
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
        //sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));

        int n = sc.nextInt();
        while (n != 0) {
            PriorityQueue<Integer> pq = new PriorityQueue();
            for (int i = 0; i < n; i++) {
                pq.add(sc.nextInt());
            }
            int sum = 0;
            while (pq.size() >= 2) {
                int a = pq.poll();
                int b = pq.poll();
                pq.add(a+b);
                sum += a + b;
            }
            System.out.println(sum);

            n = sc.nextInt();
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
