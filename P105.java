// 105 skyline

import java.util.Scanner;

public class Main {

  public static final int MAX = 10000;
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int[] a = new int[MAX];
    while (sc.hasNextInt()) {
      int start = sc.nextInt();
      int h = sc.nextInt();
      int end = sc.nextInt();
      for (int i = start; i < end; i++) {
        if (a[i] <= h) {
          a[i] = h;
        }
      }
    }

    int h = 0;
    int i = 0;
    StringBuilder s = new StringBuilder();
    outer:
    while (i < MAX) {
      while (a[i] == h) {
        i++;
        if (i >= MAX) {
          break outer;
        }
      }
      h = a[i];
      s.append(String.format("%d %d ", i, h));
    }
    s.deleteCharAt(s.length() - 1);
    System.out.println(s);
  }
}
