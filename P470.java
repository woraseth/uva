// 470 - Nasty Virus
// filter from 
// 40k < n < 80k
// to
// 4k < n < 5k

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

  static class Line {

    String line;
    char v;
    List<Character> vars;

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

    List<Character> getRightVars() {
      List<Character> list = new ArrayList<>();
      String[] a = line.split("=");
      a = a[1].split("[*+-/ ]+");
      for (int i = 0; i < a.length; i++) {
        String s = a[i];
        if (s.length() == 1 && 'a' <= s.charAt(0) && s.charAt(0) <= 'z') {
          list.add(s.charAt(0));
        }
      }
      return list;
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

  static void print(List<Line> list) {
    for (Line s : list) {
      System.out.println(s.line);
    }
//    System.out.println("----------------------");
  }

  public static void main(String[] args) {
    String first = sc.nextLine();
    final int totalLine = Integer.parseInt(first.substring(1));
    List<String> alist = new ArrayList<>();
    while (sc.hasNextLine()) {
      alist.add(sc.nextLine());
    }

    removeOtherStatement(alist);
        if (alist.size() > 80000)
      throw new RuntimeException();

//    for (String s : alist) {
//      System.out.println(s);
//    }
//    System.out.println("-----------------");

    List<Line> list = new LinkedList<>();
    for (int i = 0; i < alist.size(); i++) {
      list.add(new Line(alist.get(i)));
    }

    outer:
    while (list.size() != totalLine) {
      Set<Character> willUse = new HashSet<>(list.get(list.size() - 1).vars);
//      print(list);
//      System.out.println("---------");
      int size = list.size();
      for (int i = list.size() - 2; i >= 0; i--) {
        char v = list.get(i).v;
//        System.out.println("v = " + v);
//        System.out.println("willUse = " + willUse);
//        System.out.println("map = " + map);
        if (!willUse.contains(v)) {
          boolean canFind = false;
//          find statement below that use v and remove the statement
          for (int j = i + 1; j < list.size(); j++) {
            if (v == list.get(j).v) {
              list.remove(j);
              canFind = true;
              break;
            }
          }
          if (canFind == false) {

            list.remove(i);
          }
          continue outer;
        } else {
          willUse.remove((Character) v);
          willUse.addAll(list.get(i).vars);
        }
      }
      if (list.size() == size) {
        throw new RuntimeException();
      }
    }
    System.out.println(first);
    print(list);
  }
}
//          boolean canFind = false;
// find statement below that use v and remove the statement
//          for (int j = i + 1; j < list.size(); j++) {
//            if (v == list.get(j).v) {
//              noChange = false;
//              list.remove(j);
//              canFind = true;
//              break;
//            }
//          }
//          if (canFind == false) {
//            noChange = false;
//            list.remove(i);
//          }

//        if (!willUse.contains(v)) {
//          if (map.get(v) != null) {
//            list.remove((int) map.get(v));
//            map.put(v, i);
//          } else {
//            list.remove(i);
//          }
////          continue outer;
//        } else {
//          willUse.remove((Character) v);
//          willUse.addAll(list.get(i).vars);
//          map.put(v, i);
//        }
