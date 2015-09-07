// 12090 - Counting Zeroes
// after discussing with Ake

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  static boolean[] isPrime;
  static List<Integer> base;
  static List<Integer> power;
  static List<Integer> factor;
  static int sum = 0;

  static void allFactor(long n, int index, long f) {
//    System.out.println("hhh");
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
    for (int i = 2; i < isPrime.length; i++) {
//      System.out.println(n);
      if (i > n) {
        break;
      }
      if (isPrime[i]) {
        if (n % i == 0) {
          int count = 0;
          while (n % i == 0) {
            n /= i;
            count++;
          }
          base.add(i);
          power.add(count);
//          System.out.printf("%d^%d%n", i, count);
        }
      }
    }
  }

  static void seive() {
    int max = 10 * 1000 * 1000;
    isPrime = new boolean[max];
    Arrays.fill(isPrime, 0, max, true);
    for (int i = 2; i < isPrime.length; i++) {
      if (isPrime[i]) {
//        System.out.println(i);
        for (int j = i + i; j < isPrime.length; j += i) {
          isPrime[j] = false;
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
      factor(n);
      sum = 0;
      allFactor(n, 0, 1);
      System.out.printf("%d %d%n", n, sum);
    }
  }
}
