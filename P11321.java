// 11321 Sort! Sort!! and Sort!!!
// change Scanner to BufferedReader 
// test with tricky case such as Integer.MIN_VALUE
//    compare will not
// a student said Collections.sort() is faster than Arrays.sort
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class MyComparator implements Comparator<Integer> {
  int m;

  public MyComparator(int m) {
    this.m = m;
  }
  static boolean isOdd(int n) {
    return (n & 1) == 1;
  }

  static boolean isEven(int n) {
    return !isOdd(n);
  }

  public int compare(Integer aa, Integer bb) {
    int a = aa;
    int b = bb;
    if (a == b) return 0;
    if (a % m == b % m) {
      if (isOdd(a) && isEven(b))
        return -1;
      if (isEven(a) && isOdd(b))
        return 1;
      if (isEven(a) && isEven(b))
        return (a < b) ? -1 : 1;
      if (isOdd(a) && isOdd(b))
        return (a < b) ? 1 : -1;
    }
    return (a % m) - (b % m);
  }
}

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\in.txt"));
    int m = 0, n = 0;
    while (true) {
      String line = br.readLine();
      if (line.equals("0 0")) {
        System.out.println("0 0");
        break;
      } else {
        String[] nm = line.split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        MyComparator myComparator = new MyComparator(m);
        PriorityQueue<Integer> q = new PriorityQueue<>(n, myComparator);
        for (int i = 0; i < n; i++) {
          line = br.readLine();
          q.add(Integer.parseInt(line));
        }
        System.out.printf("%d %d%n", n, m);
        for (int i = 0; i < n; i++) {
          System.out.println(q.remove());
        }
      }
    }
  }
}
