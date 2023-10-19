// not finish
// 11212 - Editing a book
// 285 generated, 121 distinct


import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
  static Scanner sc = new Scanner(System.in);
  static int N = 9;
  static int[] w1 = new int[N];
  static int[] w2 = new int[N];

  static int[] edit(int[] v, int a, int b, int c) {
    boolean debug = false;
    int i;
    for (i = 0; i < a; i++) {
      w1[i] = v[i];
    }
    if (debug) System.out.println(Arrays.toString(w1));
    for (int j = b; j < N; j++) {
      w1[i++] = v[j];
    }
    if (debug) System.out.println(Arrays.toString(w1));
    int k;
    for (k = 0; k < c; k++) {
      w2[k] = w1[k];
    }
    if (debug) System.out.println(Arrays.toString(w2));
    for (int j = a; j < b; j++) {
      w2[k++] = v[j];
    }
    if (debug) System.out.println(Arrays.toString(w2));
    int j = c;
    for (; k < N; k++) {
      w2[k] = w1[j++];
    }
    if (debug) System.out.println(Arrays.toString(w2));
    System.out.println(Arrays.toString(w2));

    return w2;
  }

  public static void main(String[] args) throws Exception {
    HashSet<List<Integer>> set = new HashSet<>();
    // sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
    int count = 0;
    int[] a = {1,2,3,4,5,6,7,8,9};
     for (int i = 0; i < N; i++)
     for (int j = i+1; j <= N; j++)
     for (int k = 0; k <= N - (j-i); k++) {
    // edit(a,i,j,k);
    set.add(Arrays.stream(edit(a,i,j,k)).boxed().collect(Collectors.toList()));
    count++;
     }
     System.out.println(count);
     System.out.println(set.size());
     
     
    
  }
}
