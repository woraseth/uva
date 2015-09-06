// C. Space Finder
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int test = sc.nextInt();

    for (int tt = 0; tt < test; tt++) {
      String s = sc.next();
      String t = sc.next();
      if (!t.equals("-1")) {
        s = s.replaceAll(t, "");
      }
      int sum = 0;
      for (int i = 0; i < s.length(); i++) {
        sum += s.charAt(i) - '0';
      }
      System.out.println(sum);
    }
  }
}
