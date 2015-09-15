// 202 - Repeating Decimals 
// cycle detection

//1/397 = 0.(00251889168765743073047858942065491183879093198992...)
//   99 = number of digits in repeating cycle

//3/10 + 1/39700 
//119110/397000 = 0.30(002518891687657430730478589420654911838790931989...)
//   99 = number of digits in repeating cycle
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

  static Scanner sc = new Scanner(System.in);
  static List<Integer> result;
  static List<Integer> list;
  static int cycle;
  static int intPart;

  static int process(int n, int d) {
    result = new ArrayList<>();
    list = new ArrayList<>();
    cycle = -1;
    intPart = n / d;

    n = n % d;

    int t;
    while (true) {
      t = n * 10;
      n = t % d;
      if (!list.contains(t)) {
        result.add(t / d);
        list.add(t);
      } else {
        cycle = list.size() - list.indexOf(t);
        return list.indexOf(t);
      }
    }
  }

  static void output(int n, int d, int listIndex) {
    StringBuilder sb = new StringBuilder();
    if (listIndex + 1 + cycle <= 50) {
      for (int i : result) {
        sb.append(i);
      }
      sb.insert(listIndex, "(");
      sb.append(")");
      sb.insert(0, intPart + ".");
    } else {
      for (int i = 0; i < 50; i++) {
        sb.append(result.get(i));
      }
      sb.insert(listIndex, "(");
      sb.append("...)");
      sb.insert(0, intPart + ".");
    }
    System.out.printf("%d/%d = %s%n", n, d, sb);
    System.out.printf("   %d = number of digits in repeating cycle%n%n", cycle);

  }

  public static void main(String[] args) {
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      int d = sc.nextInt();

      int listIndex = process(n, d);
      output(n, d, listIndex);
    }
  }
}
