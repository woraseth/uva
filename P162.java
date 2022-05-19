import java.io.FileInputStream;
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    int getCover(String s) {
        switch (s.charAt(1)) {
            case 'Q': return 2;
            case 'K': return 3;
            case 'A': return 4;
            default:  return 1;
        }
    }
    boolean isFace(String s) {
        switch (s.charAt(1)) {
            case 'J':
            case 'Q':
            case 'K':
            case 'A': return true;
            default:  return false;
        }
    }
    void go() throws Exception {
        //sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
        while (!sc.hasNext("#")) {
            List<String> p0 = new ArrayList();
            List<String> p1 = new ArrayList();
            List<String>[] p;
            List<String> heap = new ArrayList();
            for (int i = 0; i < 52; i += 2) {
                p0.add(sc.next());
                p1.add(sc.next());
            }
            boolean faceState = false;
            p = new List[]{p0, p1};
            int cover = 0;
            int turn = 0;
            while (true) {
                if (p[turn].isEmpty()) break;
                String card = p[turn].remove(p[turn].size() - 1);
                heap.add(card);
                //System.out.printf("%d %s %d%n", turn, card, heap.size());
                if (faceState) {
                    if (isFace(card)) {
                        faceState = true;
                        turn ^= 1;
                        cover = getCover(card);
                    } else {
                        cover--;
                        if (cover == 0) {
                            turn ^= 1;
                            Collections.reverse(heap);
                            p[turn].addAll(0, heap);
                            heap.clear();
                            faceState = false;
                        }
                    }
                } else {
                    if (isFace(card)) {
                        faceState = true;
                        cover = getCover(card);
                    }
                    turn ^= 1;
                }
            }
            System.out.printf("%d %2d%n", turn + 1, p[turn ^ 1].size());
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
