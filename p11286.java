import java.io.FileInputStream;

// 11286  Conformity
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
//        sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));

        int n = sc.nextInt();
        while (n != 0) {
            Map<String, Integer> map = new HashMap();
            for (int i = 0; i < n; i++) {
                int[] a = new int[5];
                for (int j = 0; j < 5; j++) {
                    a[j] = sc.nextInt();
                }
                Arrays.sort(a);
                String s = Arrays.toString(a);
                if (map.get(s) == null) {
                    map.put(s, 1);
                } else {
                    map.put(s, map.get(s) + 1);
                }
            }
            Integer[] val = map.values().toArray(new Integer[0]);
            Arrays.sort(val);
            int max = val[val.length - 1];
            int count = 0;
            for (String s : map.keySet()) {
                if (map.get(s) == max)
                    count += max;
            }
            System.out.println(count);

            n = sc.nextInt();
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
