
// 231 Testing the CATCHER
// DP
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  static int[] h = new int[32 * 1024];
  static int length;
  static int test = 1;

  static void process() {
    int maxmax = 0;
    int[] sum = new int[length + 1];
    for (int i = length - 1; i >= 0; i--) {
      int max = 0;
      for (int j = i + 1; j <= length; j++) {
        if (h[i] > h[j]) {
          if (max < sum[j] + 1) {
            max = sum[j] + 1;
          }
        }
      }
      sum[i] = max;
      if (maxmax < max) {
        maxmax = max;
      }
//      System.out.println(java.util.Arrays.toString(sum));
    }
    if (test != 1) {
      System.out.println();
    }
    System.out.printf("Test #%d:%n", test++);
    System.out.printf("  maximum possible interceptions: %d%n", maxmax);
  }

  public static void main(String[] args) {
    while (true) {
      h[0] = sc.nextInt();
      if (h[0] == -1) {
        break;
      }

      length = 1;
      while (true) {
        int t = sc.nextInt();
        if (t == -1) {
          break;
        }
        h[length++] = t;
      }
      h[length] = 0;
//      System.out.println("length = " + length);

      process();
    }
  }
}
