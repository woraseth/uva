import java.io.FileInputStream;
// 300 - Maya Calendar
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    String[] hMonth = {"pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin", "mol", "chen",
                       "yax", "zac", "ceh", "mac", "kankin", "muan", "pax", "koyab", "cumhu",
                       "uayet"};
    String[] tDay = {"imix", "ik", "akbal", "kan", "chicchan",
    "cimi", "manik", "lamat", "muluk", "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau"};


    int hDayNo(int d, String m, int y) {
        int monthNo = 0;
        while (!m.equals(hMonth[monthNo])) monthNo++;
        return y * 365 + monthNo * 20 + d;
    }
    
    void go() throws Exception {
        //sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
        int N = sc.nextInt();
        System.out.println(N);

        String[] tDate = new String[13*20];
        int tp = 1;
        int td = 0;
        for (int i = 0; i < 13*20; i++) {
            tDate[i] = tp + " " + tDay[td];
            tp = tp == 13 ? 1 : tp + 1;
            td = td == tDay.length - 1 ? 0 : td + 1;
        }

        for (int i = 0; i < N; i++) {
            int d = Integer.parseInt(sc.next().replaceAll("\\.", ""));
            String m = sc.next();
            int y = sc.nextInt();

            int hDayNo = hDayNo(d, m, y);
            int tYear = hDayNo / (13*20);
            int tDateIndex = hDayNo % (13*20);
            System.out.printf("%s %d%n", tDate[tDateIndex], tYear);
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
