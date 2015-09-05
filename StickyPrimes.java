// Sticky Primes
// ad hoc
// efficient calculation
// problem from Pete
// I attend his lecture during Aug-Sep 2015
// seive 1M can be done at the blink of eyes

import java.util.Arrays;

public class Main {

  static boolean[] isPrimes = new boolean[1000000];

  static void seive() {
    Arrays.fill(isPrimes, 0, isPrimes.length, true);
    isPrimes[0] = false;
    isPrimes[1] = false;
    for (int i = 2; i < isPrimes.length; i++) {
      if (isPrimes[i]) {
        for (int j = i + i; j < isPrimes.length; j += i) {
          isPrimes[j] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    seive();
    int[] primes = new int[isPrimes.length / 2];
    int count = 0;
    for (int i = 0; i < isPrimes.length; i++) {
      if (isPrimes[i]) {
        primes[count++] = i;
//        System.out.println(i);
      }
    }

    int target = 311;  // 4 : 311 863, 5: 16277
    int start = 0;
    int end = 0;
    int sum = 0;
    while (!(end - start == 2 && sum > target)) {
      if (sum == target) {
        for (int i = start; i < end - 1; i++) {
          System.out.print(primes[i] + "+");
        }
        System.out.println(primes[end - 1]);
        sum += primes[end++];
      } else if (sum < target) {
        sum += primes[end++];
      } else {  // sum > target
        sum -= primes[start++];
      }
      //System.out.println(sum);
    }
  }
}
