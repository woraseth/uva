// UVa 231 - Testing the CATCHER

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static int LIS(List<Integer> list) {
    int maxmax = 1;
    int[] lis = new int[list.size()];
    lis[0] = 1;

    for (int i = 1; i < lis.length; i++) {
      int max = 1;
      for (int j = 0; j < i; j++) {
        if (list.get(i) <= list.get(j)) {
          if (lis[j] + 1 > max)
            max = lis[j] + 1;
        } 
      }
      lis[i] = max;
      if (max > maxmax)
        maxmax = max;
    }
    return maxmax;
  }

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) throws Exception {
    // sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
    int test = 1;
    while (true) {
      List<Integer> list = new ArrayList<Integer>();
      int x = sc.nextInt();
      while (x != -1) {
        list.add(x);
        x = sc.nextInt();
      }
      if (list.size() == 0) {
        break;
      } else {
        if (test > 1) System.out.printf("%n%n");
        
        System.out.printf("Test #%d:%n", test++);
        System.out.printf("maximum possible interceptions: %d", LIS(list));
      }
    }
  }
}
