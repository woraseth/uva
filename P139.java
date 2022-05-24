import java.io.FileInputStream;
// 139 Telephone Tangles
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    class Call {
        String prefix;
        int cost;
        String location;

        Call(String s) {
            int space = s.indexOf(" ");

            prefix = s.substring(0, space);
            String[] a = s.substring(space + 1, s.length()).split("\\$");
            location = a[0].trim();
            cost = Integer.parseInt(a[1]);
        }

        boolean match(String number) {
            if (number.length() < prefix.length()) return false;
            return prefix.equals(number.substring(0, prefix.length()));
        }

        String report(String number, int minute) {
            //return String.format("%-16s%-25s%10s%5d%6.2f%7.2f%n", number, location, number.substring(prefix.length(), number.length()), minute, cost, cost * minute);
            int space = 35 - location.length() - (number.length() - prefix.length());
            String s = "";
            for (int i = 0; i < space; i++) {
                s += " ";
            }
            String t = location + s + number.substring(prefix.length(), number.length());
            return String.format("%-16s%s%5d%3d.%02d%4d.%02d%n", number, t, minute, cost/100, cost%100, cost * minute/100, (cost*minute)%100);
        }
    }

    void go() throws Exception {
        //sc = new Scanner(new FileInputStream("c:\\temp\\in.txt"));
        List<Call> list = new ArrayList();

        while (!sc.hasNext("000000")) {
            list.add(new Call((sc.nextLine())));
        }
        sc.next();

        outer:
        while (!sc.hasNext("#")) {
            String number = sc.next();
            int minute = sc.nextInt();
            if (number.charAt(0) != '0') {
                // local
                System.out.printf("%-16sLocal %29s%5d%6.2f%7.2f%n", number, number, 1, 0.0, 0.0);
            } else {
                for (Call call : list) {
                    if (call.match(number)) {
                        System.out.print(call.report(number, minute));
                        continue outer;
                    }

                }
                System.out.printf("%-16s%-25s%15d%13s%n", number, "Unknown", minute, -1.0);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
