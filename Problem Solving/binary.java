import java.util.Scanner;

public class binary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();

        for (int i = 0; i < n; ++i) {
            Long s = in.nextLong();
            String b = Long.toBinaryString(s);

            int l = b.length();
            if (l%4 == 1)
                b = "000" + b;
            if (l%4 == 2)
                b = "00" + b;
            if (l%4 == 3)
                b = "0" + b;

            l = b.length();
            for (int j = 0; j < l; ++j) {
                System.out.print(b.charAt(j));
                if (j%4 == 3)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
