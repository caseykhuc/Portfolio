import java.util.Scanner;

public class tsoc15c1p1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        String[] molecular = {"Cl", "Br", "Xe", "Kr", "Si", "As", "Rn", "Ne", "He", "H", "C", "N", "O", "F", "P", "S", "I"};

        int n = in.nextInt();

        for (int i = 0; i < n; ++i) {
            String[] s = input.nextLine().split(" ");
            boolean bool = true;
            for (int j = 0; j < s.length; ++j)
                for (int k = 0; k < molecular.length; ++k)
                    if (s[j].equals(molecular[k])) {
                        bool = false;
                        break;
                    }
            if (bool == true)
                System.out.println("Not molecular!");
            else
                System.out.println("Molecular!");
        }
    }
}
