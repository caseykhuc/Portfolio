import java.util.Scanner;

public class dmopc17c5p1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] s = new char[10];

        s[0] = 'O';
        s[1] = 'l';
        s[2] = 'x';
        s[3] = 'E';
        s[4] = 'A';
        s[5] = 'S';
        s[6] = 'G';
        s[7] = 'x';
        s[8] = 'B';
        s[9] = 'g';

        String str = in.nextLine();
        for (int i = 0; i < str.length(); ++i) {
            int x = str.charAt(i) - '0';
            boolean bool = true;
            if (0 <= (x) && (x) <= 9) {
                if (s[x] != 'x') {
                    System.out.print(s[x]);
                    bool = false;
                }
            }
            if (bool == true)
                System.out.print(str.charAt(i));
        }
    }

}
