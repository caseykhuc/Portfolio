import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class dwite10c4p4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static String readLine() throws IOException {
        return br.readLine().trim();
    }

    public static void main(String[] args) throws IOException {
        for (int x = 0; x < 5; ++x) {


            String s;
            int[][] arr = new int[10][10];
            for (int i = 0; i < 10; ++i) {
                s = readLine();
                for (int j = 0; j < 10; ++j)
                    arr[i][j] = s.charAt(j) - '0';
            }
            s = readLine();

            int[][] dp = new int[10][10];

            for (int i = 0; i < 10; ++i)
                for (int j = 0; j < 10; ++j)
                    dp[i][j] = 10000000;
            for (int i = 0; i < 10; ++i)
                dp[i][0] = 0;

            for (int i = 0; i < 100000; ++i) {
                for (int j = 0; j < 10; ++j) {
                    for (int k = 1; k < 10; ++k) {
                        int min = dp[j][k];
                        if (Math.abs(arr[j][k] - arr[j][k - 1]) <= 1)  // left
                            min = Math.min(dp[j][k - 1] + 1, min);

                        if (j > 0 && Math.abs(arr[j][k] - arr[j - 1][k]) <= 1)  // above
                            min = Math.min(dp[j - 1][k] + 1, min);

                        if (j < 9 && Math.abs(arr[j][k] - arr[j + 1][k]) <= 1)  // below
                            min = Math.min(dp[j + 1][k] + 1, min);

                        dp[j][k] = min;
                    }
                }
            }

            /*for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }*/

            // Find minimum distance on the right edge
            int min = 10000000;
            for (int i = 0; i < 10; i++)
                min = Math.min(dp[i][9], min);
            if (min != 10000000)
                System.out.println(min);
            else
                System.out.println("IMPOSSIBLE");
        }
    }
}
