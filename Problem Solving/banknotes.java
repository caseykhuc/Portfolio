// Casey yo

import java.util.Arrays;
import java.util.Scanner;

public class banknotes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] b = new int[n];
        int[] c = new int[n];

        for (int i = 0; i < n; ++i) {
            b[i] = in.nextInt();
        }

        for (int i = 0; i < n; ++i) {
            c[i] = in.nextInt();
        }

        int k = in.nextInt();

        int[][][] dp = new int[n][k+1][30000];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= k; ++j) {
                for (int l = 0; l < 20000; ++l) {
                    dp[i][j][l] = 100000;
                    dp[i][0][0] = 0;
                }
            }
        }

        for (int i = 0; i < n; ++i)
            for (int l = 1; l <= c[i]; ++l)
                dp[i][b[i]][l] = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = b[i]; j <= k; ++j) {
                for (int l = 1; l <= c[i]; ++l) {
                    dp[i][j][l] = Math.min(dp[i][j][l], dp[i][j-b[i]][l-1] + 1);
                    if (i > 0) {
                        dp[i][j][l] = Math.min(dp[i][j][l], dp[i-1][j][c[i-1]]);
                        dp[i][j][l] = Math.min(dp[i][j][l], dp[i-1][j-b[i]][c[i-1]] + 1);
                    }
                }
            }
        }

        /*for (int i = 0; i < n; ++i) {
            System.out.println("b " + b[i]);
            for (int j = 0; j <= k; ++j) {
                System.out.println("k = " + j);
                for (int l = 0; l <= c[i]; ++l) {
                    System.out.print(dp[i][j][l] + " ");
                }
                System.out.println();
            }
        }*/
        System.out.println(dp[n-1][k][c[n-1]]);
    }
}