// 10533 - Digit Primes
// TLE

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  final static Scanner sc = new Scanner(System.in);

  static boolean[] isPrime;

  static void sieve(int n) {
    isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, 0, n, true);
    for (int i = 2; i < isPrime.length; i++) {
      if (isPrime[i]) {
//        System.out.println(i);
        for (int j = i + i; j < isPrime.length; j += i) {
          isPrime[j] = false;
        }
      }
    }
  }

  static int sum(int n) {
    int s = 0;
    while (n != 0) {
      s += n % 10;
      n /= 10;
    }
    return s;
  }

  public static void main(String[] args) {
    sieve(1000000);
    int tt = sc.nextInt();
    for (int t = 0; t < tt; t++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      int count = 0;
      for (int i = start; i <= end; i++) {
        if (isPrime[i] && isPrime[sum(i)]) {
          count++;
        }
      }
      System.out.println(count);
    }
  }
}
