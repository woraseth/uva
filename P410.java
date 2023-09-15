// produce different output from the example
// but the judge ACCEPT
// ???

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\in.txt"));
    int id = 1;
    while (true) {
      String line = br.readLine();
      if (line == null || line.trim().length() == 0) break;
 
      String[] tokens = line.split(" ");
      final int c = Integer.parseInt(tokens[0]);
      final int s = Integer.parseInt(tokens[1]);

      line = br.readLine();
      tokens = line.split(" ");
      int[] a = new int[2 * c];
      double avg = 0;
      for (int i = 0; i < s; i++) {
        a[i] = Integer.parseInt(tokens[i]);
        avg += a[i];
      }
      avg /= c;
       
      Arrays.sort(a);

      double sum = 0;
      for (int i = 0; i < c; i++) {
        sum += Math.abs(a[i] + a[a.length - i - 1] - avg);
      }

      System.out.printf("Set #%d%n", id++);
      int count = 0;
      for (int i = 0; i < c; i++) {
          System.out.printf(" %d:", count++);
          if (a[i] != 0) 
            System.out.printf(" %d", a[i]);
          if (a[2 * c - i - 1] != 0)
            System.out.printf(" %d", a[2 * c - i - 1]);
          System.out.println();
      }
      System.out.printf("IMBALANCE = %.5f%n%n", sum);
      
    }
    br.close();
  }
}
