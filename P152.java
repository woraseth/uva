// 152 Tree’s a Crowd
import java.util.*;

class Point {
    int x, y, z;

    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    double distance(Point o) {
        double dx = x - o.x;
        double dy = y - o.y;
        double dz = z - o.z;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
        List<Point> p = new ArrayList();
        while (true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            if (x == 0 && y == 0 && z == 0)
                break;
            p.add(new Point(x, y, z));
        }

        int[] bucket = new int[10];
        for (int i = 0; i < p.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < p.size(); j++) {
                if (i == j)
                    continue;
                int d = (int) p.get(i).distance(p.get(j));
                if (min > d) {
                    min = d;
                }
            }
            if (min < 10)
                bucket[min]++;
        }
        String s = "";
        for (int i = 0; i < bucket.length; i++) {
            s += String.format("%4d", bucket[i]);
        }
        System.out.println(s);
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
