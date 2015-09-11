// 10055 Hashmat the Brave Warrior 
// ad hoc easy 
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (sc.hasNextLong()) {
      long a = sc.nextLong();
      long b = sc.nextLong();
      System.out.println(Math.abs(a - b));
    }
  }
}
