// 10518 - How Many Calls?
// by Monirul Hasan
// 1. no cycle detection
// 2. naive (too complex) cycle detection 
// 3. smart cycle detection. for base b cycle occurs when 
//    1, 1, ...., 1, b-1, 1, 1

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);
  static int[] call;

  public static void main(String[] args) {
    int t = 1;

    while (true) {
      final long n = sc.nextLong();
      int b = sc.nextInt();
      if (n == 0 && b == 0) {
        break;
      }
      int x0 = 1;
      int x1 = 1;
      final int maxCycle = 12000;
      call = new int[maxCycle];
      call[0] = 1;
      call[1] = 1;
      int start = 0;
      int stop = 0;
      int i;
      outer:
      for (i = 2; i < maxCycle; i++) {
        int s = x0 + x1 + 1;
        x0 = x1;
        x1 = s % b;
        call[i] = x1;
        // cycle detection
        if (call[i] == b - 1 && call[i-1] == 1) {
          break;
        }
      }

      if (n <= i) {
        System.out.printf("Case %d: %d %d %d%n", t, n, b, call[(int) n]);
      } else {
        System.out.printf("Case %d: %d %d %d%n", t, n, b, call[(int) (n % (i+1))]);
      }
      t++;
    }
  }
}

