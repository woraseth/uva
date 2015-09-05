

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
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        for (int k = j; k < t.length(); k++) {
          if (c == t.charAt(k)) {
            break;
          }
          j++;
        }
        if (j == t.length()) {
          isSub = false;
        }
      }
      if (isSub) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
  }
}
