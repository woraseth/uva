import java.io.FileInputStream;

// 00000  Problem Name 
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
        sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));

    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
