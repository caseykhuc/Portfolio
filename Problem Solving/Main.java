import java.util.Scanner;

public class Main {
    static int[][] ans;
    static int n, v;
    static int[] d, c, l;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int v = input.nextInt();

        ans = new int[n][v];

        d = new int[n];
        for (int i = 0; i < n; ++i)
            d[i] = input.nextInt();
        c = new int[v];
        l = new int[v];

        for (int i = 0; i < v; ++i) {
            c[i] = input.nextInt();
            l[i] = input.nextInt();
        }
    }

    static void solve(int x, int y) {
        if (ans[x][y] > 0)
            return;

        return;
    }
}
