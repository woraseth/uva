

// 10340 All in All
// greedy
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (sc.hasNext()) {
      boolean isSub = true;
      String s = sc.next();
      String t = sc.next();
      int j = 0;
      int count = 0;
      for (int i = 0; i < s.length(); i++) {
        for (int k = j; k < t.length(); k++) {
//          System.out.print(i + " " + j + " ");
//          System.out.println(s.charAt(i) + " " + t.charAt(k));
          j++;
          if (s.charAt(i) == t.charAt(k)) {
            count++;
            break;
          }
        }
      }
      if (count == s.length()) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
  }
}
