
// 10009 All Roads Lead Where? 
// graph
// dfs on Map data structure, remember path
// Print a blank line between the outputs for two consecutive test cases.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);
  static Map<String, List<String>> map;

  static void createGraph(int road) {
    map = new HashMap<>();
    for (int r = 0; r < road; r++) {
      String c1 = sc.next();
      String c2 = sc.next();
      if (map.get(c1) == null) {
        List<String> list = new ArrayList<>();
        list.add(c2);
        map.put(c1, list);
      } else {
        map.get(c1).add(c2);
      }
    }

    // print map
//    for (String key : map.keySet()) {
//      System.out.println(key + " " + map.get(key));
//    }
  }

  static boolean findPath(String from, String to, List<String> path) {
    path.add(from);
//    System.out.println("from = " + from);
//    System.out.println("to = " + to);
//    System.out.println("path = " + path);
//    System.out.println();
    if (from.equals(to)) {
      return true;
    }
    List<String> neighbors = map.get(from);
    if (neighbors != null) {
      for (String c : neighbors) {
        if (findPath(c, to, path)) {
          return true;
        }
      }
    }
    path.remove(path.size() - 1);
    return false;
  }

  static void question() {
    String c1 = sc.next();
    String c2 = sc.next();
    List<String> p1 = new ArrayList<>();
    List<String> p2 = new ArrayList<>();
    findPath("Rome", c1, p1);
    findPath("Rome", c2, p2);
//    System.out.println(p1);
//    System.out.println(p2);
    int i;
    for (i = 1; i < Math.min(p1.size(), p2.size()); i++) {
      if (!p1.get(i).equals(p2.get(i))) {
        break;
      }
    }
    for (int j = p1.size() - 1; j >= i; j--) {
      System.out.print(p1.get(j).charAt(0));
    }
    for (int j = i - 1; j < p2.size(); j++) {
      System.out.print(p2.get(j).charAt(0));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int test = sc.nextInt();
    for (int t = 0; t < test; t++) {
      if (t != 0) {
        System.out.println();
      }
      int road = sc.nextInt();
      int question = sc.nextInt();
      createGraph(road);
      for (int q = 0; q < question; q++) {
        question();
      }
    }
  }
}
