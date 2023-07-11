// Summing Digits
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);

  static int g(int n) {
    int sum = 0;
    // sum every digit 
    while (n > 0) {
      sum += n % 10;
      n /= 10;
    }
    if (sum < 10) {
      return sum;
    } else {
      return g(sum);
    }
  }
  public static void main(String[] args) throws Exception {
    // sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
    int n = sc.nextInt();
    while (n != 0) {
      System.out.println(g(n));
      n = sc.nextInt();
    }
  }
}
