
import java.util.Scanner;

// hashmat
public class P10055 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLong()) {
      long a = sc.nextLong();
      long b = sc.nextLong();
      if (a > b) {
        System.out.println(a - b);
      } else {
        System.out.println(b - a);
      }
    }
  }
}
