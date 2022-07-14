import java.io.FileInputStream;

// 10107 What is the Median?
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
        sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
        List<Integer> list = new ArrayList();
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            list.add(n);
            Collections.sort(list);
            int size = list.size();
            if (size % 2 == 1)
                System.out.println(list.get(size/2));
            else {
                int a = list.get(size/2);
                int b = list.get(size/2 - 1);
                System.out.println((a + b) / 2);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
