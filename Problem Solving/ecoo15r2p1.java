// Casey yo
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ecoo15r2p1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ten = 10;
        while (ten > 0) {
            String cmd = br.readLine();
            String line = br.readLine();
            if (cmd.equals("decode"))
                System.out.println(decode(line));
            else
                System.out.println(encode(line));
            --ten;
        }
    }

    public static String decode(String line) {
        String[] words = line.split(" ");
        String[] dewords = new String[words.length];
        Arrays.fill(dewords, "");

        line.replace(" ", "");
        //System.out.println(line);

        String res = "";
        int countPos = 0;
        int countChar = 1;

        while (countChar > 0) {
            countChar = 0;
            for (int i = 0; i < words.length; ++i) {
                if (dewords[i].length() < words[i].length()) {
                    /*System.out.println("add " +  line.charAt(countPos));
                    System.out.println(countPos);
                    System.out.println("add to " + i);*/
                    dewords[i] += line.charAt(countPos++);
                    if (countPos < line.length())
                        if (line.charAt(countPos) == ' ')
                            ++countPos;
                    ++countChar;
                }
            }
        }

        for (int i = 0; i < dewords.length; ++i) {
            if (i < dewords.length-1)
                res += dewords[i] + " ";
            else
                res += dewords[i];
        }
        return res;
    }

    public static String encode(String line) {
        String[] words = line.split(" ");

        String res = "";
        int countPos = 0;
        int countChar = 1;

        while (countChar > 0) {
            countChar = 0;
            for (int i = 0; i < words.length; ++i) {
                if (countPos < words[i].length()) {
                    res += words[i].charAt(countPos);
                    //System.out.println("add " + words[i].charAt(countPos));
                    ++countChar;
                }
            }
            ++countPos;
        }

        countChar = -1;
        for (int i = 0; i < words.length; ++i) {
            countChar += words[i].length() + 1;
            res = res.substring(0, countChar) + " " + res.substring(countChar);
        }
        return res;
    }
}
