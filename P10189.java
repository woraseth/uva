// 10189 - Minesweeper

import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int tt = 0;
    while (sc.hasNextInt()) {
      int row = sc.nextInt();
      int col = sc.nextInt();
      if (row == 0 && col == 0) {
        break;
      }
      if (tt != 0) {
        System.out.println();
      }
      tt++;
      String[] map = new String[row];
      for (int i = 0; i < map.length; i++) {
        map[i] = sc.next();
      }

      // process
      int[][] table = new int[row + 2][col + 2];
      for (int r = 0; r < row; r++) {
        for (int c = 0; c < col; c++) {
          if (map[r].charAt(c) == '*') {
            table[r][c]++;
            table[r][c + 1]++;
            table[r][c + 2]++;
            table[r + 1][c]++;
            table[r + 1][c + 2]++;
            table[r + 2][c]++;
            table[r + 2][c + 1]++;
            table[r + 2][c + 2]++;
          }
        }
      }
      for (int r = 0; r < row; r++) {
        String s = "";
        for (int c = 0; c < col; c++) {
          if (map[r].charAt(c) == '*') {
            s += "*";
          } else {
            s += String.valueOf(table[r + 1][c + 1]);
          }
        }
        map[r] = s;
      }
      System.out.printf("Field #%d:%n", tt);
      for (int i = 0; i < map.length; i++) {
        System.out.println(map[i]);
      }
    }
  }
}
