import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _16bitswonly {
    public static String multiply(String A, String B) {
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        int[] calc = new int[arrA.length + arrB.length];

        for (int i=arrA.length-1; i>=0; --i) {
            for (int j=arrB.length-1; j>=0; --j) {
                calc[i + j + 1] += Character.getNumericValue(arrA[i]) * Character.getNumericValue(arrB[j]);
                calc[i + j] += calc[i + j + 1] / 10;
                calc[i + j + 1] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder("");

        for (int c : calc) {
            sb.append(c);
        }

        String ans = sb.toString().replaceFirst("^0*", "");
        return ans.isEmpty() ? "0" : ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());

        boolean[] ans = new boolean[n];

        for (int i = 0; i < n; ++i) {
            String[] line = br.readLine().split(" ");

            String str1 = line[0];
            String str2 = line[1];
            String res = line[2];
            if (res.equals(multiply(str1, str2)))
                ans[i] = true;
            else
                ans[i] = false;
        }

        for (int i = 0; i < n-1; ++i) {
            if (ans[i])
                System.out.println("POSSIBLE DOUBLE SIGMA");
            else
                System.out.println("16 BIT S/W ONLY");
        }

        if (ans[n-1])
            System.out.print("POSSIBLE DOUBLE SIGMA");
        else
            System.out.print("16 BIT S/W ONLY");
    }
}
