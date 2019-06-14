import java.util.Scanner;

// Casey yo
public class anct1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int d = Math.abs(in.nextInt());
        int min = 100000;

        for (int i = 0; i < n; ++i) {
            int x = in.nextInt();
            if (d%x == 0)
                min = Math.min(min, d/x);
        }

        if (min == 100000)
            System.out.println("This is not the best time for a trip.");
        else
            System.out.println(min);
    }
}
