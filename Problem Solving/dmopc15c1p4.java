// Casey yo

import java.util.Scanner;

public class dmopc15c1p4 {
    static boolean[] prime;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n, x;
        n = input.nextInt();
        x = input.nextInt();

        /*prime = new boolean[n];
        for (int i = 0; i < n; ++i)
            prime[i] = true;*/
        //initPrime(n);
        int res = 0;
        for (int i = 0; i <= n; ++i) {
            if (!isPrime(i))
                continue;
            res += Math.max(((n-i)/x) + 1, 0) + Math.max((n-i-1)/x + 1, 0);
            //System.out.println(i);
            //System.out.println("n/x " + ((n-i)/x) + "    " + ((n-1-i)/x));
        }
        System.out.println(res);
    }

    /*static void initPrime(int n) {
        for (int i = 0; i < n; ++i) {
            System.out.println(i + " " + isPrime(i));
        }
    }*/

    static boolean isPrime(int x) {
        if (x < 2)
            return false;
        boolean res = true;
        for (int i = 2; i <= x/2; ++i) {
            if ((x%i) == 0) {
                res = false;
                break;
            }
        }
        return res;
    }
}
