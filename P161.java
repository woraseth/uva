import java.io.FileInputStream;
// 161 Traffic Lights
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    class Light {
        int color = 0;
        int i;
        int cycle;

        Light(int cycle) {
            this.cycle = cycle;
        }

        void next() {
            i = (i + 1) % (cycle * 2);
        }

        char getColor() {
            if (i < cycle - 5) return 'g';
            else if (i < cycle) return 'y';
            return 'r';
        }

        public String toString() {
            return "" + getColor();
        }
    }

    void go() throws Exception {
        sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));

        outer:
        while (true) {
            List<Light> list = new ArrayList();
            int cycle = sc.nextInt();
            while (cycle != 0) {
                list.add(new Light(cycle));
                cycle = sc.nextInt();
            }
            if (list.size() == 0) {
                break;
            }
            int max = list.stream().min((e1, e2) -> e1.cycle - e2.cycle).get().cycle;

            for (int i = 0; i <= 60 * 60 * 5; i++) {
                boolean all = true;
                for (Light light : list) {
                    if (light.getColor() != 'g') {
                        all = false;
                        break;
                    }
                    ;
                }

                if (i >= max && all) {
                    System.out.printf("%02d:%02d:%02d%n", i / (60 * 60), (i / 60) % 60, i % 60);
                    continue outer;
                }
                for (Light light : list) {
                    light.next();
                }
            }
            System.out.println("Signals fail to synchronise in 5 hours");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
