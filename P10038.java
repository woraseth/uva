// 10038 - Jolly Jumpers

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      String[] ss = line.split(" ");
      // special case
      if (ss.length == 2) {
        System.out.println("Jolly");
        continue;
      }

      int[] a = new int[ss.length-1];
      boolean[] jolly = new boolean[a.length];
      for (int i = 0; i < a.length; i++) {
        a[i] = Integer.parseInt(ss[i+1]);
      }
      for (int i = 1; i < a.length; i++) {
        // even zero is in array's range, we must exclude it
        if (0 < Math.abs(a[i] - a[i - 1]) && Math.abs(a[i] - a[i - 1]) < a.length) {
          jolly[Math.abs(a[i] - a[i - 1])] = true;
        }
      }
      
      int count = 0;
      for (boolean b : jolly) {
        if (b) {
          count++;
        }
      }
      if (count == a.length - 1) {
        System.out.println("Jolly");
      } else {
        System.out.println("Not jolly");
      }
    }

  }
}
