// 12090 - Counting Zeroes
// don't forget to check if cannot factor (base.size() == 0)

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  static boolean[] nonPrime;
  static int[] prime = new int[5761455];   // 5761455 primes less than 100M
  static int primeCount;
  static List<Integer> base;
  static List<Integer> power;
  static List<Integer> factor;
  static int sum = 0;

  static void allFactor(long n, int index, long f) {
    if (index < power.size()) {
      for (int i = 0; i <= power.get(index); i++) {
        long pk = 1;
        for (int j = 0; j < i; j++) {
          pk *= base.get(index);
        }
        allFactor(n, index + 1, f * pk);
      }
    } else {
//      System.out.println(f);
      if (f != 1) {
        int count = 0;
        while (n % f == 0) {
          n /= f;
          count++;
        }
        sum += count;
      }
    }
  }

  static void factor(long n) {
    base = new ArrayList<>();
    power = new ArrayList<>();
    for (int i = 0; i < primeCount; i++) {
      int p = prime[i];
      if (p > n) {
        break;
      }

      if (n % p == 0) {
        int count = 0;
        while (n % p == 0) {
          n /= p;
          count++;
        }
        base.add(p);
        power.add(count);
//        System.out.printf("%d^%d%n", p, count);
      }
    }
  }

  static void seive() {
    int max = 50 * 1000 * 1000;
    nonPrime = new boolean[max];
    for (int i = 2; i < nonPrime.length; i++) {
      if (!nonPrime[i]) {
        prime[primeCount++] = i;
        for (int j = i + i; j < nonPrime.length; j += i) {
          nonPrime[j] = true;
        }
      }
    }
  }

  public static void main(String[] args) {
    seive();
    while (true) {
      long n = sc.nextLong();

      if (n == 0) {
        break;
      }
      
      // test prime
      BigInteger b = new BigInteger(n + "");
      if (b.isProbablePrime(128)) {  // 2714901685147 is prime
        System.out.printf("%s 1%n", b.toString());
        continue;
      }

      factor(n);
      if (base.size() != 0) {
        sum = 0;
        allFactor(n, 0, 1);
        System.out.printf("%d %d%n", n, sum);
      } else {
        System.out.printf("%d 1%n", n);
      }

    }
  }
}
