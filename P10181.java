// 10181 - 15-Puzzle Problem
// meet in the middle cannot handle 30 depth

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

  static final Scanner sc = new Scanner(System.in);

  static class State {

    int[] board;
    String move;
    int zero;

    public State(int[] board, int zero, String move) {
      this.board = new int[16];
      System.arraycopy(board, 0, this.board, 0, 16);
      this.zero = zero;
      this.move = move;
    }

    public boolean canMove(int dir) {
      // UDLR
      switch (dir) {
        case 0:
          return zero >= 4;
        case 1:
          return zero < 12;
        case 2:
          return zero % 4 != 0;
        default:
          return zero % 4 != 3;
      }
    }

    public State move(int dir) {
      State s = new State(this.board, this.zero, this.move);
      // UDLR
      switch (dir) {
        case 0:
          s.swap(zero, zero - 4);
          s.move += "U";
          break;
        case 1:
          s.swap(zero, zero + 4);
          s.move += "D";
          break;
        case 2:
          s.swap(zero, zero - 1);
          s.move += "L";
          break;
        default:
          s.swap(zero, zero + 1);
          s.move += "R";
          break;
      }
      return s;
    }

    void swap(int a, int b) {
      int t = board[a];
      board[a] = board[b];
      board[b] = t;
      zero = b;
    }

    public int hashCode() {
      int sum = zero;
      sum += board[(zero + 2) % 16];
      sum += board[(zero + 3) % 16];
      sum += board[(zero + 5) % 16];
      sum += board[(zero + 7) % 16];
      return sum;
    }

    public String toString() {
      return Arrays.toString(board) + " " + move + "\n";
    }

    public boolean equals(Object otherObject) {
      State other = (State) otherObject;
      if (zero != other.zero) {
        return false;
      }
      return Arrays.equals(board, other.board);
    }
  }

  static boolean match(Set<State> set0, Set<State> set1) {
    for (State s : set0) {
      if (set1.contains(s)) {
        for (State t : set1) {
          if (t.equals(s)) {
//            System.out.println(s.move.length() + t.move.length());
            System.out.println(s.move + opposite(t.move));
            return true;
          }
        }
      }
    }
    return false;
  }

  static String opposite(String s) {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case 'U':
          res.insert(0, 'D');
          break;
        case 'D':
          res.insert(0, 'U');
          break;
        case 'L':
          res.insert(0, 'R');
          break;
        case 'R':
          res.insert(0, 'L');
          break;
      }
    }
    return res.toString();
  }

  static Set<State> expand(Set<State> set) {
    Set<State> res = new HashSet<>();
    for (State s : set) {
      for (int i = 0; i < 4; i++) {
        if (s.canMove(i)) {
          State ns = s.move(i);
          res.add(ns);
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
//    int tt = sc.nextInt();
//    for (int t = 0; t < tt; t++) {
//      int[] start = new int[16];
    int[] start = {1,2,3,4,5,6,7,8,9,10,11,12,13,15,14,0};
      int[] goal = new int[16];
      int zero = -1;
      for (int i = 0; i < goal.length; i++) {
        goal[i] = i + 1;
//        start[i] = sc.nextInt();
        if (start[i] == 0) {
          zero = i;
        }
      }
      goal[15] = 0;
      State ss = new State(start, zero, "");
      State sg = new State(goal, 15, "");
      Set<State> upper = new HashSet<>();
      Set<State> lower = new HashSet<>();
      upper.add(ss);
      lower.add(sg);
      int count = 0;
      while (true) {
//        print(upper, lower);
        if (match(upper, lower)) {
          break;
        }
        upper = expand(upper);
//        for (State s : upper) {
//          all.add(s);
//        }
//        print(upper, lower);
        count++;
        if (match(upper, lower)) {
          break;
        }
        lower = expand(lower);
//        for (State s : lower) {
//          all.add(s);
//        }
        count++;
        System.out.println(count);
        System.out.println(upper.size());
        System.out.println(lower.size());
        if (count >= 50) {
          System.out.println("This puzzle is not solvable.");
          break;
        }
      }
//    }
  }

  static void print(Set<State> u, Set<State> l) {
    System.out.println("upper");
    System.out.println(u);
    System.out.println("lower");
    System.out.println(l);
    System.out.println("--------------------");
  }
  static Set<State> all = new HashSet<>();
}

/*

 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 14 15 0
 0

 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 15 14 0
 IMPOSSIBLE

 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 14 0 15
 1 R

 1 2 3 4
 5 6 7 8
 9 10 0 12
 13 14 11 15
 2 DR

 1 2 3 4
 5 6 7 8
 9 10 12 0
 13 14 11 15
 3 LDR

6 2 8 4 
12 14 1 10 
13 15 3 9 
11 0 5 7
50

6 8 4 2 
12 14 1 10 
13 15 3 9 
11 0 5 7
51

 */
