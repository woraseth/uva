// 10041 - Vito's Family

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


// RTE => if (nn == 0), package a!!! 
// TLE => loop won't work.  use median

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    String line = br.readLine();
    int tt = Integer.parseInt(line);
    for (int t = 0; t < tt; t++) {
      line = br.readLine();
      String[] ss = line.split(" ");
      int nn = Integer.parseInt(ss[0]);
      if (nn == 0) {
        System.out.println("0");
        continue;
      }
      int[] a = new int[nn];
      for (int i = 0; i < nn; i++) {
        a[i] = Integer.parseInt(ss[i+1]);
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

/*import java.util.Arrays;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
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
      int min = Integer.MAX_VALUE;
      for (int i = a[0]; i <= a[a.length - 1]; i++) {
//        if (!set.contains(j)) {
        int dist = 0;
        for (int s : a) {
          dist += Math.abs(s - i);
        }
        if (min > dist) {
          min = dist;
        }
//        }
      }
      System.out.println(min);
    }
  }
}
*/

/*
 import java.util.HashSet;
 import java.util.Scanner;
 import java.util.Set;
 import java.util.TreeSet;



 public class Main {
 static Scanner sc = new Scanner(System.in);
 public static void main(String[] args) {
 int tt = sc.nextInt();
 for (int i = 0; i < tt; i++) {
 int nn = sc.nextInt();
 Set<Integer> set = new TreeSet<>();
 for (int j = 0; j < nn; j++) {
 set.add(sc.nextInt());
 }
 int[] a = new int[set.size()];
 int j = 0;
 for (int n : set) {
 a[j++] = n;
 }
 int min = Integer.MAX_VALUE;
 for (j = a[0]; j <= a[a.length-1]; j++) {
 //        if (!set.contains(j)) {
 int dist = 0;
 for (int s : a) {
 dist += Math.abs(s - j);
 }
 if (min > dist) {
 min = dist;
 }
 //        }
 }
 System.out.println(min);
 }
 }
 }
 */
