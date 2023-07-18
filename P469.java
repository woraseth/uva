// 469 - Wetlands of Florida

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
  static Scanner sc = new Scanner(System.in);

  static boolean inbound(char[][] m, int r, int c) {
    if (r < 0 || c < 0) return false;
    if (r >= m.length || c >= m[0].length) return false;
    return true;
  }

  static void ff(char[][] m, int r, int c) {
    if (!inbound(m, r, c) || m[r][c] != 'W')
      return;
    m[r][c] = 'x';
    count++;
    ff(m, r-1, c-1);
    ff(m, r-1, c);
    ff(m, r-1, c+1);
    ff(m, r, c-1);
    ff(m, r, c+1);
    ff(m, r+1, c-1);
    ff(m, r+1, c);
    ff(m, r+1, c+1);
  }
  static int count;
  static int f(List<String> list, String[] a) {
    int r = Integer.parseInt(a[0]);
    int c = Integer.parseInt(a[1]);
    char[][] m = new char[list.size()][list.get(0).length()];
    for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m[0].length; j++) {
          m[i][j] = list.get(i).charAt(j);
        }
    }
    count = 0;
    ff(m, r-1, c-1);
    return count;
  }

  public static void main(String[] args) throws Exception {
    //sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
    final int N = Integer.parseInt(sc.nextLine());
    sc.nextLine();
    for (int i = 0; i < N; i++) {
      List<String> list = new ArrayList();
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        if (line.length() < 2) {
          System.out.println();
          break;
        } else if (line.charAt(0) >= 65)  {  // 'A'
          list.add(line);
        } else {
          String[] a = line.split(" ");
          System.out.println(f(list, a));
        }
      }
    }
  }
}
