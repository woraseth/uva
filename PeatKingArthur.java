// Fibonacci

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int test = sc.nextInt();

    for (int tt = 0; tt < test; tt++) {
      int n = sc.nextInt();
      if (n % 3 == 0) {
        System.out.println("even");
      } else {
        System.out.println("odd");
      }
    }
//    for (int n = 0; n < 20; n++) {
//      int f = 0;
//      if (n <= 1) {
//        f = n;
//      } else {
//        int a = 0;
//        int b = 1;
//        for (int i = 2; i <= n; i++) {
//          f = (a + b) % 2;
//          a = b;
//          b = f;
//        }
//      }
//      if ((f & 1) == 1) {
//        System.out.println("odd");
//      } else {
//        System.out.println("even");
//      }
//    }
  }
}
