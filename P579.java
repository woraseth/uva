// 579 - Clock Hands

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    while (true) {
      String line = sc.nextLine();
      String[] a = line.split(":");
      int hour = Integer.parseInt(a[0]);
      int min = Integer.parseInt(a[1]);
      if (hour == 0 && min == 0) {
        return;
      }
      double hourDegree;
      if (hour == 12) {
        hour = 0;
      }
      double minRatio = min / 60.0;
      hourDegree = (hour + minRatio) * 30;
      double minDegree = min * 6;
      double diff = Math.abs(hourDegree - minDegree);
      if (diff > 180) {
        diff = 360 - diff;
      }
      System.out.printf("%.3f%n", diff);
    }
  }
}
