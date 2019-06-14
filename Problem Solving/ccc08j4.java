// JavaProgram to convert prefix to postfix 
import java.util.*;

public class ccc08j4
{
    static boolean isOperator(char x)
    {
        switch (x)
        {
            case '+':
            case '-':
                return true;
        }
        return false;
    }

    // Convert prefix to Postfix expression
    static String preToPost(String pre_exp)
    {
        Stack<String> s= new Stack<String>();

        // length of expression
        int length = pre_exp.length();

        // reading from right to left
        for (int i = length - 1; i >= 0; i--)
        {

            // check if symbol is operator
            if (isOperator(pre_exp.charAt(i)))
            {

                // pop two operands from stack
                String op1 = s.peek(); s.pop();
                String op2 = s.peek(); s.pop();

                // concat the operands and operator
                String temp = op1 + op2 + pre_exp.charAt(i);

                // Push String temp back to stack
                s.push(temp);
            }

            // if symbol is an operand
            else
            {
                // push the operand to the stack
                s.push( pre_exp.charAt(i)+"");
            }
        }

        // stack contains only the Postfix expression
        return s.peek();
    }

    // Driver Code
    public static void main(String args[])
    {
        //String pre_exp = "--3+219";
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        while (!input.equals("0")){
            String pre_exp = "";

            for (int i = 0; i < input.length(); ++i) {
                if (input.charAt(i) != ' ')
                    pre_exp += input.charAt(i);
            }
            String post_exp = preToPost(pre_exp);
            for (int i = 0; i < post_exp.length(); ++i) {
                System.out.print(post_exp.charAt(i) + " ");
            }
            System.out.println();
            input = in.nextLine();
        }
    }
}

// This code is contributed by Arnab Kundu 