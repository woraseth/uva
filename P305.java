// 305 - Joseph

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      int k = sc.nextInt();
      if (k == 0) {
        return;
      }

      for (int n = k; n < Integer.MAX_VALUE; n++) {
        int bad = k;
        int good = k;
        int[] a = new int[k * 2];
        Arrays.fill(a, 0, k, 1);  // good is one
        int index = 0;
        while (bad != 0 && good == k) {
          while (a[index] < 0) {
            index = (index + 1) % a.length;
          }
          for (int i = 1; i < n; i++) {
            index = (index + 1) % a.length;
            while (a[index] < 0) {
              index = (index + 1) % a.length;
            }
          }
          a[index] = -1;
          if (index >= k) {
            bad--;
          } else {
            good--;
          }
        }
        if (bad == 0 && good == k) {
          System.out.println(n);
          break;
        }
      }

    }
  }
}

