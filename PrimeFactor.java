// seive
// prime factor

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  static boolean[] isPrime;
  static List<Integer> base;
  static List<Integer> power;

  static void factor(long n, int max) {
    isPrime = new boolean[max];
    base = new ArrayList<>();
    power = new ArrayList<>();
    Arrays.fill(isPrime, 0, max, true);
    for (int i = 2; i < isPrime.length; i++) {
//      System.out.println(n);
      if (i > n)
        break;
      if (isPrime[i]) {
        if (n % i == 0) {
          int count = 0;
          while (n % i == 0) {
            n /= i;
            count++;
          }
          base.add(i);
          power.add(count);
          System.out.printf("%d^%d%n", i, count);
        }
        for (int j = i + i; j < isPrime.length; j += i) {
          isPrime[j] = false;
        }
      }
    }
  }
  
  

  public static void main(String[] args) {
    long n = 900*5;
    factor(n, 10 * 1000 * 1000); 
  }
}
