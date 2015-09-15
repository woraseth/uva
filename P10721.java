// 10721 - Bar Codes
// dp

// 853 = 543 + 643 + 743    sum of m term (3)
 

import java.util.Scanner;

public class Main {

  static void process(final int nn, final int kk, final int mm) {
    long[][] table = new long[nn+1][kk+1];
    for (int i = 0; i < nn; i++) {
      table[i][0] = 1;
    }
    for (int i = 1; i <= mm && i <= nn; i++) {
      table[i][1] = 1;
    }
    for (int k = 2; k <= kk; k++) {
      for (int n = 0; n <= nn; n++) {
        long sum = 0;
        for (int m = 1; m <= mm; m++) {
          sum += table[Math.max(n-m, 0)][k-1];
        }
        table[n][k] = sum;
      }
    }
//    for (int i = 0; i <= nn; i++) {
//      System.out.println(java.util.Arrays.toString(table[i]));
//    }
    System.out.println(table[nn][kk]);
  }
  static Scanner sc = new Scanner(System.in);


  public static void main(String[] args) {
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int m = sc.nextInt();
//int n = 8;
//int k = 4;
//int m = 3;
      process(n, k, m);
    } 
  }
}
