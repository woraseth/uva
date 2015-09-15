// 147 - Dollars
// TLE if create DP table for every test case
// create DP table for the largest amount of money
// and use that table to answer every question

import java.util.Scanner;

public class Main {

  static final int[] coin = {1, 2, 4, 10, 20, 40, 100, 200, 400, 1000, 2000}; // 5c unit
  static long[][] table;

  static void process(int mm) {
    table = new long[mm + 1][coin.length];
    for (int i = 0; i < table.length; i++) {
      table[i][0] = 1;
      table[i][1] = 1;
    }
    for (int i = 0; i < table[0].length; i++) {
      table[0][i] = 1;
    }
    for (int i = 1; i < coin.length; i++) {
      int value = coin[i];
      for (int m = 1; m <= mm; m++) {
        long sum = 0;
        int c = 0;
        while (m >= value * c) {
          sum += table[m - value * c][i - 1];
          c++;
        }
        table[m][i] = sum;
      }
    }
//    for (int i = 0; i < table.length; i++) {
//      System.out.println("table[i] = " + java.util.Arrays.toString(table[i]));
//    }

  }

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    process(6000);  // 300 / 0.05
    while (true) {
      String s = sc.next();
      if (s.equals("0.00")) {
        break;
      }
//    String s = "2.00";
      String[] a = s.split("\\.");
      int d = Integer.parseInt(a[0]);
      int c = Integer.parseInt(a[1]);
      int m = d * 20 + c / 5;
//      System.out.println(m);

      System.out.printf("%3d.%02d%17d%n", d, c, table[m][coin.length - 1]);
    }
  }
}
