import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) throws Exception {
    // sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
    final int N = sc.nextInt();
    for (int i = 0; i < N; i++) {
      final int M = sc.nextInt();
      int[] a = new int[M];
      for (int j = 0; j < M; j++) {
        a[j] = sc.nextInt();
      }
      Arrays.sort(a);
      System.out.println(2 * (a[M - 1] - a[0]));
    }
  }
}
