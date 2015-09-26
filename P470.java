// 470 - Nasty Virus
// TLE even change Set to bit operation (26 vars)
// 
// filter from 
// 40k < n < 80k
// to
// 4k < n < 5k

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

  static class Line {

    String line;
    char v;
    int vars;

    Line(String line) {
      this.line = line;
      v = getLeftVar();
      vars = getRightVars();
    }

    char getLeftVar() {
      for (int i = 0; i < line.length(); i++) {
        if (line.charAt(i) == '=') {
          return line.charAt(i - 1);
        }
      }
//      return 'c';
      throw new RuntimeException();
    }

    int getRightVars() {
      int res = 0;
      String[] a = line.split("=");
      a = a[1].split("[*+-/ ]+");
      for (int i = 0; i < a.length; i++) {
        String s = a[i];
        if (s.length() == 1) {
          char c = s.charAt(0);
          if ('a' <= c && c <= 'z') {
            res |= 1 << (c - 'a');
          }
        }
      }
      return res;
    }

    public String toString() {
      StringBuilder sb = new StringBuilder(v + "=");
      for (int i = 0; i < 26; i++) {
        if ((vars & (1 << i)) != 0) {
          sb.append((char) ('a' + i));
        }
      }
      return sb.toString();
    }
  }
  static final Scanner sc = new Scanner(System.in);

  static boolean isChar(char c) {
    return 'a' <= c && c <= 'z';
  }

  static boolean isNum(char c) {
    return '0' <= c && c <= '9';
  }

  static boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
  }

  static void removeOtherStatement(List<String> list) {
    for (int i = list.size() - 1; i >= 0; i--) {
      String line = list.get(i);
      if (!line.contains("=")) {
        list.remove(i);
      } else {
//        System.out.println("------------");
//        System.out.println(line);
        boolean remove = false;
        int state = 0;
        for (int j = 0; j < line.length(); j++) {
          char c = line.charAt(j);
          switch (state) {
            case 0:
              if (isChar(c)) {
                state = 1;
              } else if (c != ' ') {
                remove = true;
              }
              break;
            case 1:
              if (c == '=') {
                state = 2;
              } else if (c != ' ') {
                remove = true;
              }
              break;
            case 2:
            case 4:
              if (isChar(c) || isNum(c)) {
                state = 3;
              } else if (c != ' ') {
                remove = true;
              }
              break;
            case 3:
              if (isOperator(c)) {
                state = 4;
              } else if (c != ' ') {
                remove = true;
              }
              break;
          }
//          System.out.println("c = " + c);
//          System.out.println("remove = " + remove);
//          System.out.println("state = " + state);
        }

        if (remove || state == 2 || state == 4 || state == 0 || state == 1) {
          list.remove(i);
        }
      }
    }
  }

  static void print(Line[] list, boolean[] mark) {
    for (int i = 0; i < list.length; i++) {
      if (!mark[i]) {
        System.out.println(list[i].line);
      }
    }
  }

  public static void main(String[] args) {
    String first = sc.nextLine();
    final int totalLine = Integer.parseInt(first.substring(1));
    List<String> alist = new ArrayList<>();
    while (sc.hasNextLine()) {
      alist.add(sc.nextLine());
    }

    removeOtherStatement(alist);

    Line[] list = new Line[alist.size()];
    boolean[] mark = new boolean[alist.size()];
    Arrays.fill(mark, false);
    for (int i = 0; i < alist.size(); i++) {
      list[i] = new Line(alist.get(i));
    }

    int mCount = 0;
    outer:
    while (totalLine != list.length - mCount) {
      int willUse = list[list.length - 1].vars;
      for (int i = list.length - 2; i >= 0; i--) {
        if (!mark[i]) {
          Line line = list[i];
          char v = line.v;
          if ((willUse & (1 << (v - 'a'))) != 0) {  // willUse contains V
            willUse ^= (1 << (v - 'a')); // willUse.remove((Character) v);
          } else {
            for (int j = i + 1; j < list.length; j++) {
              if (!mark[j] && v == list[j].v) {
                mark[j] = true;
                mCount++;
                continue outer;
              }
            }
            mCount++;
            mark[i] = true;
          }
          willUse |= line.vars;
        }
      }
    }
    System.out.println(first);
    print(list, mark);
  }
}
