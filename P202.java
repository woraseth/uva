
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 202 - Repeating Decimals
public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      final int d = sc.nextInt();
//    int n = 5;
      final int m = n;
//    final int d = 43;
      List<Integer> result = new ArrayList<>();
      List<Integer> list = new ArrayList<>();
      int cycle = -1;
      int intPart = n / d;
      n = n % d;

      int t;
      while (true) {
        int a;
         t = n * 10;
        n *= 10;
        a = n / d;
        n = n % d;
//      System.out.println(list);
        if (!list.contains(t)) {
          result.add(a);
          list.add(t);
        } else {
          cycle = list.size() - list.indexOf(t);
          break;
        }

      }
//      System.out.println(cycle);
      StringBuilder sb = new StringBuilder();
      if (list.indexOf(t) + 1 + cycle <= 50) {
        for (int i : result) {
          sb.append(i);
        }
//      sb.insert(list.indexOf(n) + cycle, ")");
        sb.insert(list.indexOf(t), "(");
        sb.append(")");
        sb.insert(0, intPart + ".");
      } else {
        for (int i = 0; i < 50; i++) {
          sb.append(result.get(i));
        }
        sb.insert(list.indexOf(t), "(");
        sb.append("...)");
        sb.insert(0, intPart + ".");
      }
      System.out.printf("%d/%d = %s%n", m, d, sb);
      System.out.printf("   %d = number of digits in repeating cycle%n", cycle);

    }
  }
}
