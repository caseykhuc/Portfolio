import java.util.Scanner;

public class ecoo12r2p3 {
    static void checkCollision(double a, int b, int c,
                               int x, int y, int radius)
    {
        // Finding the distance of line from center.
        double dist = (Math.abs(a * x + b * y + c)) /
                Math.sqrt(a * a + b * b);

        // Checking if the distance is less than,
        // greater than or equal to radius.
        if (radius == dist)
            System.out.println ( "Touch" );
        else if (radius > dist)
            System.out.println( "Intersect") ;
        else
            System.out.println( "Outside") ;
    }

    static double distance(double a, double b, double x, double y, double c) {
        double s = Math.abs(a*x + b*y + c);
        System.out.println(s);
        double d = Math.sqrt(a*a + b*b);
        System.out.println(d);
        return (double)s/d;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int D = in.nextInt();
        int L = in.nextInt();
        int N = in.nextInt();

        int count = 0;

        for (int i = 0; i < N; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            int r = in.nextInt();

            double k = Math.tan(Math.toRadians(D));
            System.out.println("Tan " + k);

            /*double dis = distance(k, -1, x, y, 0);
            System.out.println(dis);
            if (dis <= r) {
                ++count;
                System.out.println("got this ");
                System.out.println();
            }*/
            checkCollision(k, -1, 0, x, y, r);
        }
        System.out.println("The jet will appear on " + count + " radar screens.");
    }
}
