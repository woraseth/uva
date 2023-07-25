// 156 - Ananagrams
  
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class Main {
  static Scanner sc = new Scanner(System.in);

  static boolean isAnagram(String a, String b) {
    if (a.length() != b.length()) return false;
    char[] aa = a.toCharArray();
    char[] bb = b.toCharArray();
    Arrays.sort(aa);
    Arrays.sort(bb);
    for (int i = 0; i < aa.length; i++) {
        if (aa[i] != bb[i]) return false;
    }
    return true;
  }
  static boolean isAnanagram(String s, List<String> dict) {
    int count = 0;
    for (String a : dict) {
      if (isAnagram(a.toLowerCase(), s.toLowerCase()))
        count++;
    }
    return count == 1;
  }

  public static void main(String[] args) throws Exception {
    //sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
    String line = sc.nextLine();
    List<String> words = new ArrayList();
    while (line.charAt(0) != '#') {
      String[] a = line.split(" ");
      for (String s : a) words.add(s);
      line = sc.nextLine();
    }
    Collections.sort(words);
    for (String s : words) {
      if (isAnanagram(s, words))
        System.out.println(s);
    }
  }
}
