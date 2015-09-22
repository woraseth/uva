// 102 - Ecological Bin Packing
// hard code permute
// generate and test

import java.util.Scanner;

public class Main {

  static int[][] table = {{5, 10, 5}, {20, 10, 5}, {10, 20, 10}};

  static int move(int color, int bin) {
    int sum = 0;
    for (int i = 0; i < table.length; i++) {
      if (i != bin) {
        sum += table[i][color];
      }
    }
    return sum;
  }
  static int min;
  static int[] sol = {0, 0, 0};

  public static void test(int[] a) {
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += move(a[i], i);
    }
//    System.out.println("a = " + java.util.Arrays.toString(a));
//    System.out.println("sum = " + sum);
    if (min > sum) {
      min = sum;
      System.arraycopy(a, 0, sol, 0, a.length);
    }
  }
  static final char[] color = {'B', 'G', 'C'};
  static final Scanner sc = new Scanner(System.in);
  static final int[][] all = {{0, 2, 1}, {0, 1, 2},
  {2, 0, 1}, {2, 1, 0},
  {1, 0, 2}, {1, 2, 0}
  };

  public static void main(String[] args) {
    while (sc.hasNextInt()) {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          table[i][j] = sc.nextInt();
        }
      }
      min = Integer.MAX_VALUE;
      for (int[] perm : all) {
        test(perm);
      }
      for (int i = 0; i < 3; i++) {
        System.out.print(color[sol[i]]);
      }
      System.out.println(" " + min);
    }
  }
}
