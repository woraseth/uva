// 10891 - Game of Sum

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final Scanner sc = new Scanner(System.in);
  static int[] val;
  static long[][] memo ;
  static long opt(int a, int b) {
    if (a > b || b < a) return 0;
    if (memo[a][b] == Long.MIN_VALUE) {
      long sum = 0;
      long max = Long.MIN_VALUE;
      for (int i = a; i <= b; i++) {
        sum += val[i];
        long total = sum - opt(i + 1, b);
        if (max < total) {
          max = total;
        }
      }
      sum = 0;
      for (int i = b; i >= a; i--) {
        sum += val[i];
        long total = sum - opt(a, i - 1);
        if (max < total) {
          max = total;
        }
      }
      memo[a][b] = max;
    }
    return memo[a][b];
  }
  public static void main(String[] args) {
    while (true) {
      int n = sc.nextInt();
      if (n == 0)
        break;
      val = new int[n];
      memo = new long[n][n];
      for (int i = 0; i < n; i++) {
        Arrays.fill(memo[i], Long.MIN_VALUE);
      }
      for (int i = 0; i < n; i++) {
        val[i] = sc.nextInt();
        memo[i][i] = val[i];
      }
      System.out.println(opt(0, n-1));
    }
  }
}
