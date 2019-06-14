import java.util.Scanner;

// Casey yo
public class aminusb {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for (int i = 0; i < n; ++i) {
            int a, b;
            a = in.nextInt();
            b = in.nextInt();

            System.out.println(a-b);
        }
    }
}
