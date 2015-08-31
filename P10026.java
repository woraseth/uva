// 10026 Shoemaker

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  static class Job {

    int n, day, fine;

    public Job(int n, int day, int fine) {
      this.n = n;
      this.day = day;
      this.fine = fine;
    }

    public String toString() {
      return "(" + n + " " + day + " " + fine + ")";
    }
  }

  static void question() {
    job.sort(new Comparator<Job>() {

      @Override
      public int compare(Job o1, Job o2) {
        int max = Math.max(o1.day, o2.day);
        int a = o1.fine * max / o1.day;
        int b = o2.fine * max / o2.day;
        if (a > b) {
          return -1;
        } else if (a == b) {
          if (o1.day > o2.day) {
            return 1;
          } else if (o1.day == o2.day) {
            return 0;
          } else {
            return -1;
          }
        } else {
          return 1;
        }
      }
    });
//    System.out.println(job);
    for (int i = 0; i < job.size(); i++) {
      if (i != 0) {
        System.out.print(" ");
      }
      System.out.print(job.get(i).n);
    }
    System.out.println();
  }

  static List<Job> job;

  public static void main(String[] args) {
    int test = sc.nextInt();
    for (int t = 0; t < test; t++) {
      int city = sc.nextInt();
      job = new ArrayList<>();
      for (int c = 0; c < city; c++) {
        job.add(new Job(c + 1, sc.nextInt(), sc.nextInt()));
      }

      question();
    }
  }
}
