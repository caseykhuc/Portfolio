// Casey yo

import java.util.*;

public class ccc07j5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a, b;
        a = in.nextInt();
        b = in.nextInt();

        List<Integer> motel = new ArrayList<Integer>();
        motel.add(0);
        motel.add(990);
        motel.add(1010);
        motel.add(1970);
        motel.add(2030);
        motel.add(2940);
        motel.add(3060);
        motel.add(3930);
        motel.add(4060);
        motel.add(4970);
        motel.add(5030);
        motel.add(5990);
        motel.add(6010);
        motel.add(7000);

        int n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            int x = in.nextInt();
            motel.add(x);
        }

        Collections.sort(motel);

        long[] dp = new long[motel.size()];

        dp[0] = 1;

        for (int i = 1; i < motel.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (motel.get(i) - motel.get(j) >= a && motel.get(i) - motel.get(j) <= b)
                    dp[i] += dp[j];
            }
        }

        System.out.println(dp[motel.size()-1]);
    }
}
