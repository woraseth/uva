// 591 - Box of Bricks
// Output a blank line after each set.
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int tt = 1;
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      if (n == 0)
        return;
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      
      // process
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += a[i];
      }
      int h = sum / n;
      int count = 0;
      for (int i = 0; i < n; i++) {
        if (a[i] > h)
          count += a[i] - h;
//        if (a[i] < h)
//          count += (h - a[i]);
      }
      
      System.out.printf("Set #%d%n", tt);
      System.out.printf("The minimum number of moves is %d.%n", count);
      System.out.println();
      tt++;
    }
  }
}
