import java.io.FileInputStream;
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    int getValue(String s) {
        switch (s.charAt(0)) {
            case 'A': return 1;
            case 'T': return 10;
            case 'J': return 11;
            case 'Q': return 12;
            case 'K': return 13;
            default:  return Integer.parseInt(""+s.charAt(0));
        }
    }
    void go() throws Exception {
        //sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
        while (!sc.hasNext("#")) {
            String[] deck = new String[52];
            for (int i = 51; i >= 0; i--) {
                deck[i] = sc.next();
            }
            List<String>[] pile = new List[14];
            int[] faceDownCount = new int[14];
            for (int i = 0; i < pile.length; i++) {
                pile[i] = new ArrayList();
                faceDownCount[i] = 4;
            }
            int clockHand = 1;
            for (int i = 0; i < 52; i++) {
                pile[clockHand].add(0, deck[i]);
                clockHand = clockHand == 13? 1 : clockHand + 1;
            }
            // begin
            clockHand = 13;
            String current = null;
            int exposed = 0;
            while (true) {
                if (faceDownCount[clockHand] == 0) break;
                current = pile[clockHand].remove(0);
                exposed++;
                faceDownCount[clockHand]--;
                clockHand = getValue(current);
                pile[clockHand].add(current);

            }
            System.out.printf("%02d,%s%n", exposed, current);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
