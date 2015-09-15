// 10518 - How Many Calls?
// TLE even with cycle detection
// cycle occurs when a pair is repeated
// cycle can be longer than the base
// should find cycle in Parallel.  use only 25% cpu

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);
  static int[] call;

  public static void main(String[] args) {
    int t = 1;

    while (true) {
      int n = sc.nextInt();
      int b = sc.nextInt();
      if (n == 0 && b == 0) {
        break;
      }
      int x0 = 1;
      int x1 = 1;
      call = new int[12000];
      call[0] = 1;
      call[1] = 1;
      int start = 0;
      int stop = 0;
      outer:
      for (int i = 2; i < 12000; i++) {
        int s = x0 + x1 + 1;
        x0 = x1;
        x1 = s % b;
        call[i] = x1;
        // find cycle
        for (int j = 0; j <= i; j++) {
          int p0 = call[j];
          int p1 = call[j + 1];
          for (int k = j + 1; k <= i; k++) {
            if (p0 == call[k] && p1 == call[k + 1]) {
              start = j;
              stop = k;
              break outer;
            }
          }
        }
      }

      System.out.printf("%d %d%n", start, stop);
      if (n <= start) {
        System.out.printf("Case %d: %d %d %d%n", t, n, b, call[n]);
      } else {
        int cycle = stop - start;
        System.out.printf("cycle %d%n", cycle);
        int index = (n - start) % cycle;
        System.out.printf("Case %d: %d %d %d%n", t, n, b, call[start + index]);
      }
      t++;
    }
  }
}

