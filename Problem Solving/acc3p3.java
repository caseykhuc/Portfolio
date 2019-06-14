// Casey yo

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acc3p3 {
    static int n;
    static String[] s;
    static int[][][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = Integer.parseInt(token.nextToken());

        s = new String[n];
        a = new int[n][][];
        int[] pos = new int[n];

        for (int i = 0; i < n; ++i) {
            s[i] = br.readLine();
            a[i] = new int[s[i].length()][26];
            pos[i] = 0;
        }

        init();

        String ans = "";

        for (char c = 'z'; c >= 'a'; --c) {
            int[] tempPos = new int[n];
            for (int i = 0; i < n; ++i) {
                tempPos[i] = pos[i];
            }
            int min = 100000;
            for (int i = 0; i < n; ++i) {
                int count = a[i][s[i].length()-1][c-'a'] - a[i][pos[i]][c-'a'];
                if (pos[i] == 0)
                    count = a[i][s[i].length()-1][c-'a'];
                min = Math.min(min, count);
            }

            if (min == 0)
                continue;
            for (int i = 0; i < min; ++i)
                ans += c;
            for (int i = 0; i < n; ++i)
                pos[i] = s[i].lastIndexOf(c);
        }

        if (ans.equals(""))
            ans = "-1";

        System.out.println(ans);
    }

    private static void init() {
        for (int i = 0; i < n; ++i)
            for (char c = 'a'; c <= 'z'; ++c)
                if (s[i].charAt(0) == c)
                    a[i][0][c-'a'] = 1;
                else
                    a[i][0][c-'a'] = 0;
        for (int i = 0; i < n; ++i)
            for (int j = 1; j < s[i].length(); ++j)
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (s[i].charAt(j) == c)
                        a[i][j][c-'a'] = a[i][j-1][c-'a'] + 1;
                    else
                        a[i][j][c-'a'] = a[i][j-1][c-'a'];
                }


        /*for (char c = 'a'; c <= 'z'; ++c) {
            System.out.println("c = " + c);
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < s[i].length(); ++j)
                    System.out.print(a[i][j][c - 'a'] + " ");
                System.out.println();
            }
        }*/
    }
}
