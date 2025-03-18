
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
            Set<Integer> jackSet = new HashSet();
            Set<Integer> jillSet = new HashSet();
            for (int i = 0; i < jack; i++) {
                jackSet.add(sc.nextInt());
            }
            for (int i = 0; i < jill; i++) {
                jillSet.add(sc.nextInt());
            }
            int count = 0;
            for (int i : jackSet) {
                if (jillSet.contains(i))
                    count++;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
