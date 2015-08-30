
// 10474 marble
// cannot use binary search because this problem requires
// the first index
//
import java.util.Arrays;
import java.util.Scanner;

public class Main {

  static int[] a = new int[10001];
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    int k = 1;
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      if (n == 0 && q == 0) {
        break;
      }

      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      Arrays.sort(a, 0, n);

      sb.append(String.format("CASE# %d:%n", k++));
      for (int i = 0; i < q; i++) {
        int key = sc.nextInt();
        int index;
        for (index = 0; index < n; index++) {
          if (a[index] == key) {
            break;
          }
        }
        if (index < n) {
          sb.append(String.format("%d found at %d%n", key, index + 1));
        } else {
          sb.append(String.format("%d not found%n", key));
        }
      }

    }
    System.out.print(sb);
  }
}
