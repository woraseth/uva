// 543 - Goldbach's Conjecture

import java.util.Arrays;
import java.util.Scanner;

public class Main { 

  static Scanner sc = new Scanner(System.in);
  static boolean[] isPrime;

  static int[] primes;
  static int pCount;

  static void sieve(int n) {
    primes = new int[n / 2];
    pCount = 0;
    isPrime = new boolean[n];
    Arrays.fill(isPrime, 0, n, true);
    for (int i = 2; i < isPrime.length; i++) {
      if (isPrime[i]) {
        primes[pCount++] = i;
        for (int j = i + i; j < isPrime.length; j += i) {
          isPrime[j] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    sieve(1000000);
    while (true) {
      int n = sc.nextInt();

      if (n == 0) {
        return;
      }
      int maxP;
      for (maxP = 0; maxP < pCount; maxP++) {
        if (n < primes[maxP]) {
          break;
        }
      }

      int p0 = 0, p1 = 0;
      outer:
      for (int i = 0; i < maxP; i++) {
        int m = n;
        m -= primes[i];
        for (int j = 0; j < maxP; j++) {
          if (m == primes[j]) {
            p0 = primes[i];
            p1 = primes[j];
            break outer;
          }
        }
      }

//      if (p0 + p1 == n) {
        System.out.printf("%d = %d + %d%n", n, p0, p1);
//      } else {
//        System.out.println("Goldbach's conjecture is wrong.");
//      }
    }
  }
}
