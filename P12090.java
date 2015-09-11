// 12090 - Counting Zeroes
// after discussing with ake
// TLE
// cover if cannot factor   isPrime()
// cover 1 0
// cover 9999999999999 24

// 9999999999999 = 265371653 x 3^2 x 53 x 79
// sqrt(9999999999999) = 3162277
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  static boolean[] nonPrime;
//  static final int max = 4 * 1000 * 1000;  // sqrt(10e13) = 3162278
//  static int[] prime = new int[283146];   // 228180 primes less than 'max'
    static final int max = 3170000;  // sqrt(10e13) = 3162278 
  static int[] prime = new int[228180];   // 228180 primes less than 'max'
  static int primeCount;
  static List<Long> base;
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
//      System.out.println("factor " + f);
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
        base.add((long) p);
        power.add(count);
//        System.out.printf("%d^%d%n", p, count);
      }
    }
    if (n != 1) {
      base.add(n);  // 9999999999999 = 265371653 x 3^2 x 53 x 79
      power.add(1);
    }
  }

  static void seive() {
    nonPrime = new boolean[max];
    for (int i = 2; i < max; i++) {
      if (!nonPrime[i]) {
        prime[primeCount++] = i;
        for (int j = i + i; j < max; j += i) {
          nonPrime[j] = true;
        }
      }
    }
  }

  public static void main(String[] args) {
    seive();
//    System.out.println(primeCount); // 1857859
//    System.out.println(prime[primeCount-1]);  // 29999999
    while (true) {
      long n = sc.nextLong();

      if (n == 0) {
        break;
      }
      // special case
      if (n == 1) {
        System.out.println("1 0");
        continue;
      }
      // test prime
      BigInteger b = new BigInteger(n + "");
      if (b.isProbablePrime(256)) {
        System.out.printf("%s 1%n", b.toString());
        continue;
      }
      // normal case
      factor(n);
      if (base.size() != 0) {  // can factor
        sum = 0;
        allFactor(n, 0, 1);
        System.out.printf("%d %d%n", n, sum);
      } else {
        throw new RuntimeException();  // n is prime (should be previously detected!!!)
      }
    }
  }
}
