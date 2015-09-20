// 1061 - Consanguine Calculations
// {} not need if only item in a set

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  static String[][] type = {{"AA", "AO"}, {"BB", "BO"}, {"AB"}, {"OO"}};

  static Set<String> addCharge(Set<String> set, String r0, String r1) {
    Set<String> res = new TreeSet<>();   // accept even with HashSet   cool!
    // but the judge doesn't count the number of character
    if (r0.equals("-") && r1.equals("-")) {
      for (String s : set) {
        res.add(s + "-");
      }
    } else {
      for (String s : set) {
        res.add(s + "-");
        res.add(s + "+");
      }
    }
    return res;
  }

  static Set<String> conclude(Set<String> set) {
    Set<String> res = new HashSet<>();
    if (set.contains("AA") || set.contains("AO") || set.contains("OA")) {
      res.add("A");
    }
    if (set.contains("BB") || set.contains("BO") || set.contains("OB")) {
      res.add("B");
    }
    if (set.contains("AB") || set.contains("BA")) {
      res.add("AB");
    }
    if (set.contains("OO")) {
      res.add("O");
    }
    return res;
  }

  static int getIndex(String b) {
    switch (b) {
      case "A":
        return 0;
      case "B":
        return 1;
      case "AB":
        return 2;
      default:
        return 3;
    }
  }

  public static Set<String> findChild(String p0, String r0, String p1, String r1) {
//    String p0 = "AB";
//    String p1 = "AB";
//    String r0 = "+";
//    String r1 = "-";
    String[] a0 = type[getIndex(p0)];
    String[] a1 = type[getIndex(p1)];
    Set set = new HashSet<>();
    for (int i = 0; i < a0.length; i++) {
      for (int j = 0; j < 2; j++) {
        char c0 = a0[i].charAt(j);
        for (int k = 0; k < a1.length; k++) {
          for (int l = 0; l < 2; l++) {
            char c1 = a1[k].charAt(l);
            set.add("" + c0 + c1);
          }
        }
      }
    }
//    System.out.println(set);
    set = conclude(set);
//    System.out.println(set);
    set = addCharge(set, r0, r1);
    return set;
  }

  public static Set<String> findParent(String p0, String r0, String ch) {
//    String p0 = "O";
//    String r0 = "+";
//    String ch = "O-";
    String[] all = {"A", "B", "AB", "O"};
    Set<String> res = new TreeSet<>();
    for (int i = 0; i < all.length; i++) {
      if (findChild(p0, r0, all[i], "+").contains(ch)) {
        res.add(all[i] + "+");
      }
      if (findChild(p0, r0, all[i], "-").contains(ch)) {
        res.add(all[i] + "-");
      }
    }
    return res;
  }

  static Scanner sc = new Scanner(System.in);

  public static String solveChild(String p0, String p1) {
    String p00 = p0.substring(0, p0.length() - 1);
    String p01 = p0.substring(p0.length() - 1);
    String p10 = p1.substring(0, p1.length() - 1);
    String p11 = p1.substring(p1.length() - 1);
//        System.out.printf("%s %s %s %s%n", p00, p01, p10, p11);
    Set<String> set = findChild(p00, p01, p10, p11);
    String child;
    if (set.size() == 1) {
      child = set.iterator().next();
    } else {
      child = set.toString().replace('[', '{').replace(']', '}');
    }
    return child;
  }

  static String solveParent(String p, String ch) {
    String p0 = p.substring(0, p.length() - 1);
    String p1 = p.substring(p.length() - 1);
    Set<String> set = findParent(p0, p1, ch);
    String res = "IMPOSSIBLE";
//          if (set.size() == 1) {
//            parent = set.iterator().next();
//          } else 
    if (set.size() > 0) {
      res = set.toString().replace('[', '{').replace(']', '}');
    }
    return res;
  }

  public static void main(String[] args) {
    int tt = 1;
    while (true) {
      String p0 = sc.next();
      String p1 = sc.next();
      String ch = sc.next();

      if (p0.equals("E") && p1.equals("N") && ch.equals("D")) {
        return;
      }
      if (ch.equals("?")) {
        System.out.printf("Case %d: %s %s %s%n", tt++, p0, p1, solveChild(p0, p1));
      } else {
        if (p0.equals("?")) {
          System.out.printf("Case %d: %s %s %s%n", tt++, solveParent(p1, ch), p1, ch);
        } else {
          System.out.printf("Case %d: %s %s %s%n", tt++, p0, solveParent(p0, ch), ch);
        }
      }
    }
  }
}
