// 11450 Wedding shopping
// DP
 
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
      pay = new int[money + 1][item];
      price = new int[item][];
      for (int i = 0; i < item; i++) {
        int model = sc.nextInt();
        price[i] = new int[model];
        for (int j = 0; j < model; j++) {
          price[i][j] = sc.nextInt();
        }
      }
      // process
      for (int m = 1; m <= money; m++) {
        for (int p = 0; p < price[0].length; p++) {
          if (pay[m][0] < price[0][p] && m >= price[0][p]) {
            pay[m][0] = price[0][p];
          }
        }
      }

      for (int i = 1; i < item; i++) {
        for (int m = 0; m <= money; m++) {
          for (int p = 0; p < price[i].length; p++) {
            if (pay[Math.max(0, m - price[i][p])][i - 1] != 0) {
              int pp = price[i][p] + pay[Math.max(0, m - price[i][p])][i - 1];
              if (pay[m][i] < pp && pp <= m) {
                pay[m][i] = pp;
              }
            }
          }
        }
      }

      // output
      if (pay[money][item - 1] == 0) {
        System.out.println("no solution");
      } else {
        System.out.println(pay[money][item - 1]);
      }
    }
  }
}
