// sieve

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  static boolean[] isPrime;

  static void sieve(int n) {
    isPrime = new boolean[n];
    Arrays.fill(isPrime, 0, n, true);
    for (int i = 2; i < isPrime.length; i++) {
      if (isPrime[i]) {
        System.out.println(i);
        for (int j = i + i; j < isPrime.length; j += i) {
          isPrime[j] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    seive(50);  
  }
}
