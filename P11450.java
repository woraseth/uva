// 11450 Wedding shopping

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  static int[][] pay;
  static int[][] price;

  public static void main(String[] args) {
    int test = sc.nextInt();
    for (int t = 0; t < test; t++) {
      // input
      int money = sc.nextInt();
      int item = sc.nextInt();
      pay = new int[money + 1][item + 1];
      price = new int[item][];
      for (int i = 0; i < item; i++) {
        int model = sc.nextInt();
        price[i] = new int[model];
        for (int j = 0; j < model; j++) {
          price[i][j] = sc.nextInt();
        }
//        System.out.println("price[i] = " + java.util.Arrays.toString(price[i]));
      }
      // process
      for (int m = 0; m <= money; m++) {
        for (int i = 0; i < item; i++) {
          for (int p = 0; p < price[i].length; p++) {
            int pp = price[i][p] + pay[Math.max(0, m - price[i][p])][i];
            if (pp <= m && pay[m][i + 1] < pp) {
              pay[m][i + 1] = pp;
            }
          }
        }
//        System.out.printf("pay[%d] = %s%n", m, java.util.Arrays.toString(pay[m]));
      }

      // check if pay is in increasing order
      boolean noSolution = false;
      int pp = pay[money][0];
      for (int i = 0; i <= item; i++) {
        if (pp > pay[money][i]) {
          noSolution = true;
          break;
        }
        if (pp <= pay[money][i]) {
          pp = pay[money][i];
        }
      }
      
      if (noSolution)
        System.out.println("no solution");
      else
        System.out.println(pay[money][item]);

    }
  }
}
