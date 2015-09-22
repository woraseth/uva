// 10533 - Digit Primes
// TLE 

import java.util.Scanner;

public class Main {

  final static Scanner sc = new Scanner(System.in);

  static boolean[] isComposite;
  static boolean[] isComposite2;

  static void sieve(int n) {
    isComposite = new boolean[n + 1];
    isComposite[0] = true;
    isComposite[1] = true;
    //Arrays.fill(isNotPrime, 0, n, true);
    for (int i = 2; i < isComposite.length; i++) {
      if (!isComposite[i]) {
//        System.out.println(i);
        for (int j = i + i; j < isComposite.length; j += i) {
          isComposite[j] = true;
        }
      }
    }
    isComposite2 = new boolean[n + 1];
    for (int i = 0; i < isComposite.length; i++) {
      if (isComposite[i])
        isComposite2[i] = true;
      else {
        isComposite2[i] = isComposite[sum(i)];
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
//    System.out.println("isComposite = " + java.util.Arrays.toString(isComposite));
    int tt = sc.nextInt();
    for (int t = 0; t < tt; t++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      int count = 0;
      for (int i = start; i <= end; i++) {
        if (!isComposite2[i]) {
          count++;
        }
      }
      System.out.println(count);
    }
  }
}
