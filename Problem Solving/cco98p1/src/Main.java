import java.util.Scanner;

public class Main {
    static String[] fibo = new String[300];

    static String cal_fibo(int n) {
        if (!fibo[n].equals("0"))
            return fibo[n];
        else {
            fibo[n] = add(cal_fibo(n-2), cal_fibo(n-1));
            return fibo[n];
        }
    }

    static String add(String x, String y) {
        int[] res = new int[100];

        int last = Math.max(x.length(), y.length());
        int i = 0;
        int debt = 0;
        while (i < last) {
            int xint, yint;
            if (i >= x.length())
                xint = 0;
            else
                xint = Character.getNumericValue(x.charAt(x.length()-i-1));
            if (i >= y.length())
                yint = 0;
            else
                yint = Character.getNumericValue(y.charAt(y.length()-i-1));

            if (xint + yint + debt > 9) {
                res[i] = xint + yint + debt - 10;
                debt = 1;
            }
            else {
                res[i] = xint + yint + debt;
                debt = 0;
            }
            ++i;
        }

        if (debt == 1) {
            res[i] = 1;
        } else
            --i;

        String s = "";
        for (int j = i; j >= 0; --j) {
            s += Integer.toString(res[j]);
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < fibo.length; ++i) {
            fibo[i] = "0";
        }
        fibo[1] = "1";
        fibo[2] = "1";

        int n;
        n = input.nextInt();
        while (n > 0 ) {
            System.out.println(cal_fibo(n));
            n = input.nextInt();
        }
        /*String x = input.nextLine();
        String y = input.nextLine();
        System.out.println(add(x, y));*/
    }
}
