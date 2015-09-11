
// 10020 Minimal coverage
// greedy
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);
  static int[] left = new int[100 * 1024];
  static int[] right = new int[100 * 1024];
  static int totalRange;

  static int cover(int i, int start) {
    if (left[i] <= start && right[i] > start) {
      return right[i] - start;
    } else {
      return Integer.MIN_VALUE;
    }
  }
 
  static class Range {

    int left;
    int right;

    public Range(int left, int right) {
      this.left = left;
      this.right = right;
    }

  }

  static void findCoverage(int m) {
    List<Range> result = new ArrayList<>();

    int count = 0;
    int start = 0;
    while (true) {
      int max = 0;
      int maxIndex = -1;
      for (int i = 0; i < totalRange; i++) {
        int c = cover(i, start);
        if (max < c) {
          max = c;
          maxIndex = i;
        }
      }
      if (maxIndex == -1) {   // cannot cover
        break;
      } else {
        start = right[maxIndex];
        result.add(new Range(left[maxIndex], right[maxIndex]));
        count++;
      }
      if (start >= m) {
        break;
      }
    }

    // output
    if (start < m) {
      System.out.println(0);
    } else {
      Collections.sort(result, new Comparator<Range>() {

        @Override
        public int compare(Range o1, Range o2) {
          if (o1.left < o2.left) {
            return -1;
          } else if (o1.left == o2.left) {
            return 0;
          } else {
            return 1;
          }
        }

      });
      System.out.println(count);
      for (Range r : result) {
        System.out.printf("%d %d%n", r.left, r.right);
      }
    }
  }

  public static void main(String[] args) {
    int test = sc.nextInt();
    for (int t = 0; t < test; t++) {
      if (t > 0) {
        System.out.println();
      }

      // input
      int m = sc.nextInt();
      totalRange = 0;
      while (true) {
        int tl = sc.nextInt();
        int tr = sc.nextInt();
        if (tl == 0 && tr == 0) {
          break;
        }
        left[totalRange] = tl;
        right[totalRange] = tr;
        totalRange++;
      }

      findCoverage(m);
    }
  }
}
