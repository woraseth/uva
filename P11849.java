
// 11849  CD 
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
        while (true) {
            int jack = sc.nextInt();
            int jill = sc.nextInt();
            if (jack == 0 && jill == 0)
                break;
            if (jack == 0 || jill == 0) {
                System.out.println(0);
                break;
            }

            int[] a = new int[jack];
            for (int i = 0; i < jack; i++) {
                a[i] = sc.nextInt();
            }

            int pJack = 0;
            int count = 0;
            for (int i = 0; i < jill; i++) {
                int x = sc.nextInt();
                if (pJack >= a.length)
                    continue;
                if (pJack < a.length && x == a[pJack]) {
                    count++;
                    pJack++;
                } else {
                    while (pJack < a.length && x > a[pJack]) {
                        pJack++;
                    }
                    if (pJack < a.length && x == a[pJack]) {
                        count++;
                        pJack++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
