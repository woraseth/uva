// 10533 - Digit Primes
// Java 2.759 vs C 1.455
// Fight with TLE : BufferedReader, StringTokenizer, index 'dp' 

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
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tt = Integer.parseInt(br.readLine());
    for (int t = 0; t < tt; t++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(tokenizer.nextToken());
      int end = Integer.parseInt(tokenizer.nextToken());
      int i = 0;
      while (dp[i++] < start);

      int j;
      if (end > 809213) {
        j = dpLen - 1;
      } else if (end > 626953) {
        j = 25000;
      } else if (end > 453371) {
        j = 20000;
      } else if (end > 287851) {
        j = 15000;
      } else {
        j = 10000;
      }

      while (dp[j--] > end);

      sb.append(j - i + 3);
      sb.append('\n');
    }
    System.out.print(sb);
  }
}
