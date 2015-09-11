// 201 - Squares
// ad hoc 
// inner class, Set, hashCode, equals

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

  static void process(int tt, final int size) {
    System.out.println("Problem #" + tt);
    System.out.println();
    boolean hasSquare = false;
    for (int sz = 1; sz < size; sz++) {
      int count = 0;
      for (int r = 1; r <= size - sz; r++) {
        for (int c = 1; c <= size - sz; c++) {
          if (hasSquare(sz, r, c)) {
            count++;
            hasSquare = true;
          }
        }
      }
      if (count > 0) {
        System.out.printf("%d square (s) of size %d%n", count, sz);
      }
    }
    if (!hasSquare) {
      System.out.println("No completed squares can be found.");
    }
  }

  static boolean hasSquare(int sz, int r, int c) {
    for (int i = 0; i < sz; i++) {
      if (!h.contains(new Pos(r, c + i))) {
        return false;
      }
    }
    for (int i = 0; i < sz; i++) {
      if (!h.contains(new Pos(r + sz, c + i))) {
        return false;
      }
    }
    for (int i = 0; i < sz; i++) {
      if (!v.contains(new Pos(r + i, c))) {
        return false;
      }
    }
    for (int i = 0; i < sz; i++) {
      if (!v.contains(new Pos(r + i, c + sz))) {
        return false;
      }
    }
    return true;
  }

  static class Pos {

    int r, c;

    public Pos(int r, int c) {
      this.r = r;
      this.c = c;
    }

    @Override
    public int hashCode() {
      int hash = 5;
      hash = 71 * hash + this.r;
      hash = 71 * hash + this.c;
      return hash;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      final Pos other = (Pos) obj;
      if (this.r != other.r) {
        return false;
      }
      if (this.c != other.c) {
        return false;
      }
      return true;
    }

  }
  static Scanner sc = new Scanner(System.in);
  static Set<Pos> h;
  static Set<Pos> v;

  public static void main(String[] args) {
    int tt = 1;
    while (sc.hasNextInt()) {
      if (tt != 1) {
        System.out.println();
        System.out.println("**********************************");
        System.out.println();
      }
      int size = sc.nextInt();
      int line = sc.nextInt();
      h = new HashSet<>();
      v = new HashSet<>();
      for (int i = 0; i < line; i++) {
        String s = sc.next();
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (s.equals("H")) {
          h.add(new Pos(a, b));
        } else {
          v.add(new Pos(b, a));  // :(
        }
      }

      process(tt++, size);
    }
  }
}
