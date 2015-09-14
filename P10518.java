// 10518 - How Many Calls?

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);


  public static void main(String[] args) {
    int t = 1;
    while (true) {
      int n = sc.nextInt();
      int b = sc.nextInt();
      if (n == 0 && b == 0) break;
      
      int x0 = 1;
      int x1 = 1;
      for (int i = 2; i <= n; i++) {
        int s = x0 + x1 + 1;
        x0 = x1;
        x1 = s;
        x1 %= b;
      }
      System.out.printf("Case %d: %d %d %d%n", t, n, b, x1);
      t++;
    }
  }
}
