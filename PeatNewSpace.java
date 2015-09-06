
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int test = sc.nextInt();

    for (int tt = 0; tt < test; tt++) {
      System.out.printf("Case #%d%n", tt + 1);
      String s = "3.14159265358979323846264338327950288419716939937510";
      String[] p = {"22", "33.3", "35.5", "52.163", "10.3993", "24.5850922"};
      String[] r = {"7", "10.6", "11.3", "16.604", "3.3102", "7.8256779"};
      BigDecimal[] mypi = new BigDecimal[p.length];
      for (int i = 0; i < mypi.length; i++) {
        mypi[i] = new BigDecimal(p[i]).divide(new BigDecimal(r[i]), 50, RoundingMode.HALF_UP);
      }

      int n = sc.nextInt();

      for (int i = 0; i < mypi.length; i++) {
        if (i != 0) {
          System.out.print(" ");
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
          if (mypi[i].toString().charAt(j + 2) != s.charAt(j + 2)) {
            count++;
          }
        }
        System.out.print(count);
      }
      System.out.println();
    }
  }
}
