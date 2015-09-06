// F Sweet Dessert
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int test = sc.nextInt();

    for (int tt = 0; tt < test; tt++) {
      String s = sc.next();
      String t = sc.next();
//    String s = "aB3d";
//    String t = "da3BC";
//    String s = "cbxabde";
//    String t = "ckabaxbdke";
      int[][] m = new int[s.length() + 1][t.length() + 1];
      for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < t.length(); j++) {
          if (s.charAt(i) == t.charAt(j)) {
            m[i + 1][j + 1] = m[i][j] + 1;
          } else {
            m[i + 1][j + 1] = Math.max(m[i][j + 1], m[i + 1][j]);
          }
        }
      }
      System.out.println(m[s.length()][t.length()]);
    }
  }
}
