// 470 - Nasty Virus

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static final Scanner sc = new Scanner(System.in);

  static void removeOtherStatement(List<String> list) {
    for (int i = list.size() - 1; i >= 0; i--) {
      String line = list.get(i);
      if (line.charAt(7) != '=') {
        list.remove(i);
      }
    }
  }

  static void print(List<String> list) {
    for (String s : list) {
      System.out.println(s);
    }
//    System.out.println("----------------------");
  }

  static List<Character> getRightVars(String line) {
    List<Character> list = new LinkedList<>();
    String[] a = line.split("[=*+-/ ]+");
    for (int i = 0; i < a.length; i++) {
      String s = a[i];
      if (s.length() == 1 && 'a' <= s.charAt(0) && s.charAt(0) <= 'z') {
        list.add(s.charAt(0));
      }
    }
    list.remove(0);
    return list;
  }

  static char getLeftVar(String line) {
    String[] a = line.split("[=*+-/ ]+");
    for (int i = 0; i < a.length; i++) {
      String s = a[i];
      if (s.length() == 1 && 'a' <= s.charAt(0) && s.charAt(0) <= 'z') {
        return s.charAt(0);
      }
    }
    throw new RuntimeException();
  }

  public static void main(String[] args) {
    String first = sc.nextLine();
    final int totalLine = Integer.parseInt(first.substring(1));
    List<String> list = new ArrayList<>();
    while (sc.hasNextLine()) {
      list.add(sc.nextLine());
    }

    removeOtherStatement(list);

    while (list.size() != totalLine) {
//      print(list);
      List<Character> vars = getRightVars(list.get(list.size() - 1));
      for (int i = list.size() - 2; i >= 0; i--) {
        char v = getLeftVar(list.get(i));
        if (vars.contains(v)) {
          vars.remove((Character) v);
          vars.addAll(getRightVars(list.get(i)));
        } else {
          boolean canFind = false;
          // find statement below that use v and remove the statement
          for (int j = i + 1; j < list.size(); j++) {
            if (v == getLeftVar(list.get(j))) {
              list.remove(j);
              canFind = true;
              break;
            }
          }
          if (canFind == false) {
            list.remove(i);
          }
          continue;
        }
      }
    }
    System.out.println(first);
    print(list);
  }
}
