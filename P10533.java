// 10533 - Digit Primes
// TLE
// reading input 0.232
// sieve         0.069

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static boolean[] isComposite;
  static int[] dp;
  static int dpLen;

  static void sieve(int n) {
    dp = new int[30200];
    dpLen = 0;
    isComposite = new boolean[n + 1];
    isComposite[0] = true;
    isComposite[1] = true;
    for (int i = 2; i < isComposite.length; i++) {
      if (!isComposite[i]) {
        int m = i;
        int s = 0;
        while (m != 0) {
          s += m % 10;
          m /= 10;
        }
        if (!isComposite[s]) {
          dp[dpLen++] = i;
        }
        for (int j = i + i; j < isComposite.length; j += i) {
          isComposite[j] = true;
        }
      }
    }
    dp[dpLen] = Integer.MAX_VALUE;  // terminate
  }

  public static void main(String[] args) throws Exception {
    sieve(1000000);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int tt = Integer.parseInt(br.readLine());
    for (int t = 0; t < tt; t++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(tokenizer.nextToken());
      int end = Integer.parseInt(tokenizer.nextToken());
      int count = 0;
      int i = 0;
      while (dp[i++] < start);
      int si = i - 1;
      if (end > 500000) {
        i = dpLen - 1;
        while (dp[i--] > end);
        sb.append(i - si + 2);
      } else {
        while (dp[i++] <= end);
        sb.append(i - si - 1);
      }
//      sb.append('\n');
    }
//    System.out.print(sb);
  }
}
