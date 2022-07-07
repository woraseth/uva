import java.io.FileInputStream;

// 12478 Hardest Problem Ever (Easy)
// should use char[]?
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);
    String[] grid = {"obidaibkr", "rkaulhisp", "sadiyanno", "heisawhia", "irakibuls", "mfbintrno", "utoyzifah", "lebsynune", "emotional"};
    String[] chck = {"obidaibkr", "rkaulhisp", "sadiyanno", "heisawhia", "irakibuls", "mfbintrno", "utoyzifah", "lebsynune", "emotional"};

    String[] names = {"rakibul", "anindya", "moshiur", "shiplu", "kabir", "sunny", "obaida", "wasi"};
    String[] chknm = {"rakibul", "anindya", "moshiur", "shiplu", "kabir", "sunny", "obaida", "wasi"};

    boolean eq(String a, String b) {
        char[] c = a.toCharArray();
        char[] d = b.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);
        return Arrays.equals(c, d);
    }

    int find(String name, String[] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <= grid[i].length() - name.length(); j++) {
                String sub = grid[i].substring(j, j + name.length());
                if (eq(name, sub)) {
//                    System.out.printf("%s %d %s%n", grid[i], j, name);
                    count++;
                }
            }
        }
        return count;
    }

    void checkInput() {
        for (int i = 0; i < grid.length; i++) {
            assert grid[i].equals(chck[i]);
        }
        for (int i = 0; i < names.length; i++) {
            assert names[i].equals(chknm[i]);
        }
    }

    String[] grid2;

    void makeGrid2() {
        grid2 = new String[grid[0].length()];
        for (int i = 0; i < grid2.length; i++) {
            String s = "";
            for (int j = 0; j < grid.length; j++) {
                s += grid[j].charAt(i);
            }
            grid2[i] = s;
        }

    }

    void go() throws Exception {
//        sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
        checkInput();
        makeGrid2();
        // check
        for (int i = 0; i < names.length; i++) {
            int count = 0;
            String name = names[i];
            count += find(name, grid);
            count += find(name, grid2);
//            System.out.printf("%s %d%n",name, count);
            if (count == 2) {
                System.out.println(name.toUpperCase());
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
