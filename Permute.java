
public class Permute {

  public static void permute(int[] a, int n) {
    if (n == a.length - 1) {
      System.out.println("a = " + java.util.Arrays.toString(a));
      return;
    }
    
    for (int i = n; i < a.length; i++) {
      swap(a, i, n);
      permute(a, n + 1);
      swap(a, n, i);
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4};
    permute(a, 0);
  }

  public static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
