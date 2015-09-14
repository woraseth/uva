// 10970 - Big Chocolate

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (sc.hasNextInt()) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      if (x > y) {
        int t = x;
        x = y;
        y = t;
      }
      int count = x - 1;
      count += (count + 1) * (y - 1);
      System.out.printf("%d%n", count);
    }
  }
}
