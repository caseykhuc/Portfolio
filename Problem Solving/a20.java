import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());

        for (int i = 0; i < n; ++i) {
            String hex = br.readLine();
            String bin = Long.toBinaryString(Long.parseLong(hex, 16));

            System.out.println(hex);
            System.out.println(bin);

            if (bin.length() <= 20) {

            } else {
                if (bin.charAt(bin.length()-21) == '0') {
                    System.out.println(hex);
                    continue;
                } else {
                    System.out.print(proper(Long.toHexString(Long.parseLong(bin, 2) - 1048576)) + " ");
                    System.out.println(hex);
                }
            }
        }
    }

    private static String proper(String str) {
        str = str.toUpperCase();
        int leading0 = 8-str.length();
        for (int i = 0; i < leading0; ++i) {
            str = '0' + str;
        }
        return str;
    }
}
