// 507 Jill Rides Again
// DP
// count[i] = s < 0 ? 0 : count[i - 1] + 1;
// WA
// count[i] = sum[i] < 0 ? 0 : count[i - 1] + 1;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);
  static int[] a;

  static void process(int t) {
    int[] sum = new int[a.length];
    int[] count = new int[a.length];
    for (int i = 1; i < sum.length; i++) {
      int s = sum[i - 1] + a[i];
      sum[i] = s <= 0 ? 0 : s;
      count[i] = s < 0 ? 0 : count[i - 1] + 1;
    }
//    System.out.println("------");
//    System.out.println(java.util.Arrays.toString(sum));
//    System.out.println(java.util.Arrays.toString(count));
    int max = Integer.MIN_VALUE;
    int maxIndex = -1;
    for (int i = 0; i < sum.length; i++) {
      if (max < sum[i]) {
        max = sum[i];
        maxIndex = i;
      } else if (max == sum[i]) {
        if (count[maxIndex] < count[i]) {
          maxIndex = i;
        }
      }
    }

    int zeroIndex = maxIndex - count[maxIndex];
    if (sum[maxIndex] <= 0) {
      System.out.printf("Route %d has no nice parts%n", t + 1);
    } else {
      System.out.printf("The nicest part of route %d is between stops %d and %d%n", t + 1, zeroIndex + 1, maxIndex + 1);
    }
  }

  public static void main(String[] args) {
    int test = sc.nextInt();

    for (int t = 0; t < test; t++) {
      // input
      int stop = sc.nextInt();
      a = new int[stop];
      for (int s = 1; s < stop; s++) {
        a[s] = sc.nextInt();
      }

      process(t);
    }
  }
}

/*
10

6 
1 
0 
0 
0 
1 


6 
1 
0 
0 
1 
-1 

6 
0 
0 
0 
0 
0 

10 
4 
-5 
4 
-3 
4 
4 
-4 
4 
-5 

10 
4 
-5 
4 
-3 
4 
4 
-4 
4 
5 

6 
-1 
1 
-1 
1 
-1 

6 
1 
-1 
1 
-1 
1 

11 
1 
-1 
1 
-1 
1 
-1 
1 
-1 
1 
-1 

12 
1 
-1 
1 
-1 
1 
-1 
1 
-1 
1 
-1 
1 

7
1
-1
1
-100
1
-1
1
*/
