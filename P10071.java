// 10071 - Back to High School Physics

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (sc.hasNextInt()) {
      int v = sc.nextInt();
      int t = sc.nextInt();

      v *= 2;

      System.out.printf("%d%n", v * t);
    }
  }
}
