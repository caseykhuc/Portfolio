import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class acc1p3 {
    static int n;
    static long t;
    static long[][] a;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        t = input.nextLong();

        a = new long[n][2];

        for (int i = 0; i < n; ++i) {
            a[i][0] = input.nextLong();
            a[i][1] = input.nextLong();
        }

        Arrays.sort(a, new Comparator<long[]>() {
            @Override
            //arguments to this method represent the arrays to be sorted
            public int compare(long[] o1, long[] o2) {
                //get the item ids which are at index 0 of the array
                long item1 = o1[0];
                long item2 = o2[0];
                // sort on item id
                return Long.compare(item2, item1);
            }
        });

        /*for (int i = 0; i < n; ++i) {
            System.out.println(a[i][0] +  " " +  a[i][1]);
        }*/
        System.out.println(solve());
    }

    static long solve() {
        long res = 0;
        while (t > 0) {
            long maxA = a[0][0];
            int maxPos = 0;
            for (int i = 0; i < n; ++i) {
                if (a[i][0] > maxA) {
                    maxA = a[i][0];
                    maxPos = i;
                }
            }
            if (maxA < 0)
                break;
            res += maxA;
            a[maxPos][0] -= a[maxPos][1];
            --t;
        }
        return res;
    }
}
