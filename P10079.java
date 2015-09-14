// 10079 – Pizza Cutting
// return long

import java.util.Scanner;

public class Main {
  static long process(int n) {
    if (n == 0) return 1;
    long x0 = 2;
    for (int i = 2; i <= n; i++) {
      x0 += i;
    }
    return x0;
  }

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      if (n < 0)
        break;
      
      System.out.println(process(n));
    }
  } 
}
