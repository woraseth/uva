// 10035 - Primary Arithmetic
// 999 + 1

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (sc.hasNext()) {
      String s = sc.next();
      String t = sc.next();
      int a = Integer.parseInt(s);
      int b = Integer.parseInt(t);
      if (a == 0 && b == 0) {
        break;
      }
      int carry = 0;
      int c = 0;
      for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
        int m = a % 10;
        int n = b % 10;
        if (m + n + c > 9) {
          carry++;
          c = 1;
        } else {
          c = 0;
        }
        a /= 10;
        b /= 10;
      }
//      System.out.printf("a=%d b=%d%n", a, b);
      int x = Math.max(a, b);
      while (x > 0 && (x % 10) + c > 9) {
        carry++;
        x /= 10;
      }
      if (carry == 0) {
        System.out.println("No carry operation.");
      } else if (carry == 1) {
        System.out.println("1 carry operation.");
      } else {
        System.out.printf("%d carry operations.%n", carry);
      }
    }
  }
}
