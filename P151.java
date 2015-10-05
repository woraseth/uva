// 151 - Power Crisis

import java.util.Scanner;

public class Main {

  static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      int n = sc.nextInt();
      if (n == 0) {
        return;
      }
      int last = 12;
      outer:
      //** terminating condition can be > m but don't know the upper bound
      for (int m = 1; m < Integer.MAX_VALUE; m++) {
        //** 
        boolean[] bs = new boolean[n];
        int count = n;
        int i = 0;
//        System.out.println("m = " + m);
        while (true) {
          if (i == last && count == 1) {
            System.out.println(m);   // found solution
            break outer;
          }
//          System.out.println(i);
          bs[i] = true;
          count--;
          if (count == 0) {
            continue outer;
          }

          //** next
          for (int j = 0; j < m; j++) {
            i = (i + 1) % n;
            while (bs[i] == true) {
              i = (i + 1) % n;
            }
          }
        }
      }
    }
  }
}
