import java.util.Scanner;

public class dmpg19b4 {
    public static void main(String[] args) {
        String[][] arr = new String[27][3];
//A
        arr[0][0] = "o.";
        arr[0][1] = "..";
        arr[0][2] = "..";
//B
        arr[1][0] = "o.";
        arr[1][1] = "o.";
        arr[1][2] = "..";
//C
        arr[2][0] = "oo";
        arr[2][1] = "..";
        arr[2][2] = "..";
//D
        arr[3][0] = "oo";
        arr[3][1] = ".o";
        arr[3][2] = "..";
//E
        arr[4][0] = "o.";
        arr[4][1] = ".o";
        arr[4][2] = "..";
//F
        arr[5][0] = "oo";
        arr[5][1] = "o.";
        arr[5][2] = "..";
//G
        arr[6][0] = "oo";
        arr[6][1] = "oo";
        arr[6][2] = "..";
//H
        arr[7][0] = "o.";
        arr[7][1] = "oo";
        arr[7][2] = "..";
//I
        arr[8][0] = ".o";
        arr[8][1] = "o.";
        arr[8][2] = "..";
//J
        arr[9][0] = ".o";
        arr[9][1] = "oo";
        arr[9][2] = "..";
//K
        arr[10][0] = "o.";
        arr[10][1] = "..";
        arr[10][2] = "o.";
//L
        arr[11][0] = "o.";
        arr[11][1] = "o.";
        arr[11][2] = "o.";
//M
        arr[12][0] = "oo";
        arr[12][1] = "..";
        arr[12][2] = "o.";
//N
        arr[13][0] = "oo";
        arr[13][1] = ".o";
        arr[13][2] = "o.";
//O
        arr[14][0] = "o.";
        arr[14][1] = ".o";
        arr[14][2] = "o.";
//P
        arr[15][0] = "oo";
        arr[15][1] = "o.";
        arr[15][2] = "o.";
//Q
        arr[16][0] = "oo";
        arr[16][1] = "oo";
        arr[16][2] = "o.";
//R
        arr[17][0] = "o.";
        arr[17][1] = "oo";
        arr[17][2] = "o.";
//S
        arr[18][0] = ".o";
        arr[18][1] = "o.";
        arr[18][2] = "o.";
//T
        arr[19][0] = ".o";
        arr[19][1] = "oo";
        arr[19][2] = "o.";
//U
        arr[20][0] = "o.";
        arr[20][1] = "..";
        arr[20][2] = "oo";
//V
        arr[21][0] = "o.";
        arr[21][1] = "o.";
        arr[21][2] = "oo";
//W
        arr[22][0] = ".o";
        arr[22][1] = "oo";
        arr[22][2] = ".o";
//X
        arr[23][0] = "oo";
        arr[23][1] = "..";
        arr[23][2] = "oo";
//Y
        arr[24][0] = "oo";
        arr[24][1] = ".o";
        arr[24][2] = "oo";
//Z
        arr[25][0] = "o.";
        arr[25][1] = ".o";
        arr[25][2] = "oo";

        arr[26][0] = "..";
        arr[26][1] = "..";
        arr[26][2] = "..";

        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        String[] ans = new String[3];
        ans[0] = "";
        ans[1] = "";
        ans[2] = "";

        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
                for (int j = 0; j < 3; ++j)
                    ans[j] += arr[26][j];
            } else {
                for (int j = 0; j < 3; ++j)
                    ans[j] += arr[str.charAt(i) - 'A'][j];
            }
        }

        for (int j = 0; j < 3; ++j)
            System.out.println(ans[j]);
    }
}
