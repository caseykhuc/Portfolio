import java.util.*;
import java.lang.*;

public class ecoo12r2p2 {

    public static int length(String password) {
        int count;
        int mark = 0;

        mark += password.length() * 4;
        return mark;
    }

    public static int basic(String password)
    {
        int count;

        boolean length=false;
        int upperCase[] = {0,0,1};
        int lowerCase[] = {0,0,1};
        int symbol[] = {0,0,0};
        int digit[] = {0,0,0,1};
        int bonus = 0;
        int result = 0;

        int mark=0;
        for(count=0; count<password.length(); count++)
        {
            if((password.length()>8))
            {
                length = true;
            }
            if (Character.isUpperCase(password.charAt(count)))
            {
                upperCase[0]=1;
                upperCase[1]++;
                if((count+1)<=(password.length()-1))
                {
                    if(Character.isUpperCase(password.charAt(count+1)))
                    {
                        upperCase[2]++;
                    }
                }
            }
            if(Character.isLowerCase(password.charAt(count)))
            {
                lowerCase[0]=1;
                lowerCase[1]++;

                if((count+1)<=(password.length()-1))
                {
                    if(Character.isLowerCase(password.charAt(count+1)))
                    {
                        lowerCase[2]++;
                    }
                }
            }
            if (Character.isDigit(password.charAt(count)))
            {
                digit[0]=1;
                digit[1]++;
                if((count!=0)&&(count!=(password.length()-1)))
                {
                    digit[2]++;
                }

                if((count+1)<=(password.length()-1))
                {
                    if(Character.isDigit(password.charAt(count+1)))
                    {
                        digit[3]++;
                    }
                }
            }
            if((!Character.isUpperCase(password.charAt(count))&&(!Character.isLowerCase(password.charAt(count))&&(!Character.isDigit(password.charAt(count))))))
            {
                symbol[0]=1;
                symbol[1]++;
                if((count!=0)&&(count!=(password.length()-1)))
                {
                    symbol[2]++;
                }

            }
        }

        if((upperCase[1]+lowerCase[1])==password.length())
        {
            bonus-= password.length();
        }

        if(digit[1]==password.length())
        {
            bonus-= password.length();
        }

        mark = lowerCase[0]+upperCase[0]+symbol[0]+digit[0];
        int mark2 = (password.length()-upperCase[1])*2 + (password.length()-lowerCase[1])*2 + 4*digit[1] + 6*symbol[1];
        int mark3 = 2*(symbol[2]+digit[2]);

        int mark4 = 0-2*(upperCase[2]-1)-2*(lowerCase[2]-1)-2*(digit[3]-1);
        if((mark>=3)&&length)
        {
            result+=10;
        }

        result+=mark2+mark3+bonus+mark4;

        return result;
    }

    static int seq_digits(String s) {
        int count = 0;

        if (Character.isDigit(s.charAt(0)))
            count = 1;

        int max = count;

        for (int i = 1; i < s.length(); ++i) {
            //System.out.println(count);
            if (Character.isDigit(s.charAt(i))) {
                if (count > 0 && s.charAt(i) == (s.charAt(i-1) + 1)) {
                    count += 1;
                    max = Math.max(max, count);
                }
                else {
                    count = 1;
                    max = Math.max(max, count);
                }
            }
            else {
                count = 0;
                max = Math.max(max, count);
            }
        }

        //--------
        if (Character.isDigit(s.charAt(0)))
            count = 1;

        max = Math.max(max, count);

        for (int i = 1; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                if (count > 0 && s.charAt(i) == (s.charAt(i-1) - 1)) {
                    count += 1;
                    max = Math.max(max, count);
                }
                else {
                    count = 1;
                    max = Math.max(max, count);
                }
            }
            else {
                count = 0;
                max = Math.max(max, count);
            }
        }

        return max;
    }

    static int seq_letter(String s) {
        int count = 0;

        if (Character.isLowerCase(s.charAt(0)))
            count = 1;

        int max = count;

        for (int i = 1; i < s.length(); ++i) {
            //System.out.println(count);
            if (Character.isLowerCase(s.charAt(i))) {
                if (count > 0 && s.charAt(i) == (s.charAt(i-1) + 1)) {
                    count += 1;
                    max = Math.max(max, count);
                }
                else {
                    count = 1;
                    max = Math.max(max, count);
                }
            }
            else {
                count = 0;
                max = Math.max(max, count);
            }
        }

        //--------
        if (Character.isLowerCase(s.charAt(0)))
            count = 1;

        max = Math.max(max, count);

        for (int i = 1; i < s.length(); ++i) {
            if (Character.isLowerCase(s.charAt(i))) {
                if (count > 0 && s.charAt(i) == (s.charAt(i-1) - 1)) {
                    count += 1;
                    max = Math.max(max, count);
                }
                else {
                    count = 1;
                    max = Math.max(max, count);
                }
            }
            else {
                count = 0;
                max = Math.max(max, count);
            }
        }
        //--------

        if (Character.isUpperCase(s.charAt(0)))
            count = 1;

        max = Math.max(count, max);

        for (int i = 1; i < s.length(); ++i) {
            if (Character.isUpperCase(s.charAt(i))) {
                if (count > 0 && s.charAt(i) == (s.charAt(i-1) - 1)) {
                    count += 1;
                    max = Math.max(max, count);
                }
                else {
                    count = 1;
                    max = Math.max(max, count);
                }
            }
            else {
                count = 0;
                max = Math.max(max, count);
            }
        }

        //----------
        if (Character.isUpperCase(s.charAt(0)))
            count = 1;

        max = Math.max(count, max);

        for (int i = 1; i < s.length(); ++i) {
            if (Character.isUpperCase(s.charAt(i))) {
                if (count > 0 && s.charAt(i) == (s.charAt(i-1) + 1)) {
                    count += 1;
                    max = Math.max(max, count);
                }
                else {
                    count = 1;
                    max = Math.max(max, count);
                }
            }
            else {
                count = 0;
                max = Math.max(max, count);
            }
        }
        //----------

        return max;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String password = input.nextLine();
        int mark = 0;

        mark = basic(password);

        System.out.println(mark);

        if (seq_letter(password) > 2)
            mark -= (3*(seq_digits(password)-2));
        if (seq_digits(password) > 2)
            mark -= (3*(seq_letter(password)-2));

        /*System.out.println(basic(password));
        System.out.println(seq_letter(password));
        System.out.println(seq_digits(password));*/
        System.out.println(mark);

    }
}