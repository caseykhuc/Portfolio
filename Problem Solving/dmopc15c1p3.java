import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmopc15c1p3 {

    char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer token = new StringTokenizer(br.readLine());

        String s = br.readLine();
        String sm = br.readLine();

        int min = 100;
        String res = "";

        for (int i = 0; i <= 26; ++i) {
            res = cipher(s, i);
            //System.out.println(res);
            if (res.contains(sm)) {
                min = i;
                break;
            }
        }
        System.out.println(min);
        System.out.println(res);
    }

    static String cipher(String str, int shift){
        shift = 26 - shift;
        String s = "";
        int len = str.length();
        for(int x = 0; x < len; x++){
            char c = (char)(str.charAt(x) + shift);
            if (c > 'z')
                s += (char)(str.charAt(x) - (26-shift));
            else
                s += (char)(str.charAt(x) + shift);
        }
        return s;
    }
}
