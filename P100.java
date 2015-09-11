// 100 - The 3n + 1 problem

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (sc.hasNextInt()) {
      int i = sc.nextInt();
      int j = sc.nextInt();
      boolean swap = false;
      if (i > j) {  // swap :(
        swap = true;
        int t = i;
        i = j;
        j = t;
      }
      int max = Integer.MIN_VALUE;
      for (int kk = i; kk <= j; kk++) {
        int k = kk;
        int count = 1;
        while (k != 1) {
          if (k % 2 == 0) {
            k /= 2;
          } else {
            k *= 3;
            k++;
          }
          count++;
        }
        if (max < count) {
          max = count;
        }
      }
      if (swap) {  // swap :(
        int t = i;
        i = j;
        j = t;
      }
      System.out.printf("%d %d %d%n", i, j, max);
    }
  }
}
