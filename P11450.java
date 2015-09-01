// 11450 Wedding shopping

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  static int[][] pay;
  static int[][] choose;
  static int[][] price;

  public static void main(String[] args) {
    int test = sc.nextInt();
    outer:
    for (int t = 0; t < test; t++) {
      // input
      int money = sc.nextInt();
      int item = sc.nextInt();
      pay = new int[money + 1][item + 1];
      choose = new int[money + 1][item + 1];
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
      for (int m = 1; m <= money; m++) {
        for (int i = 0; i < item; i++) {
          for (int p = 0; p < price[i].length; p++) {
            int pp = price[i][p] + pay[Math.max(0, m - price[i][p])][i];
            if (pp <= m && pay[m][i + 1] < pp) {
              pay[m][i + 1] = pp;
              choose[m][i+1] = price[i][p];
            }
          }
//          if (pay[m][i] != 0 && pay[m][i+1] < pay[m][i]) {
//            System.out.println("no solution");
//            break outer;
//          }
        }
//        System.out.printf("pay[%d] = %s%n", m, java.util.Arrays.toString(pay[m]));
//        System.out.printf("choose[%d] = %s%n", m, java.util.Arrays.toString(choose[m]));
      }

      // check if pay is in increasing order
      boolean noSolution = false;
      int c = money;
      for (int i = item; i > 0; i--) {
//        System.out.println(choose[c][i]);
        if (choose[c][i] == 0) {
          noSolution = true;
          break;
        }
        c -= choose[c][i];
      }
      if (noSolution)
        System.out.println("no solution");
      else
        System.out.println(pay[money][item]);

    }
  }
}
