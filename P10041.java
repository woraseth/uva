// 10041 - Vito's Family

// RTE => if (nn == 0), package a!!! 
// TLE => loop won't work.  use median
// Scanner, BufferedReader 0.392, 0.279

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) throws Exception {
    int tt = sc.nextInt();
    for (int t = 0; t < tt; t++) {
      int nn = sc.nextInt();
      if (nn == 0) {
        System.out.println("0");
        continue;
      }
      int[] a = new int[nn];
      for (int i = 0; i < nn; i++) {
        a[i] = sc.nextInt();
      }
      Arrays.sort(a);
//      int min = Integer.MAX_VALUE;
//      for (int i = a[0]; i <= a[a.length - 1]; i++) {
////        if (!set.contains(j)) {
//        int dist = 0;
//        for (int s : a) {
//          dist += Math.abs(s - i);
//        }
//        if (min > dist) {
//          min = dist;
//        }
////        }
//      }
      int i = a[a.length / 2];
      int dist = 0;
        for (int s : a) {
        dist += Math.abs(s - i);
      }
      
      System.out.println(dist);
    }
  }
}
