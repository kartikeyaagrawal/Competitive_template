import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        in.init(false);
        List<List<Integer>> a= new LinkedList();

        sol();

        in.dinit();
    }

    // static int k;
    static int n;
    static int arr[];
    static int dp[][];
    final static int mod = 1000000007;

    private static void sol() throws IOException {
        n = in.readInt();
        int k = in.readInt();
        // this.n = in.readInt();
        arr = new int[n];
        dp = new int[n + 1][k + 1];
        // for (int i[] : dp) {
        // Arrays.fill(i, -1);
        // }
        // Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            arr[i] = in.readInt();
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0)
                    dp[i][j] = 0;

                if (j == 0)
                    dp[i][j] = 1;

            }
        }
        int ans = jump(n, k);
        System.out.println(ans);

    }

    static int jump(int i, int k) {

        if (i == 0) {
            if (k == 0) {
                return 1;
            }
            return 0;

        }
        if (dp[i][k] != 0) {
            return dp[i][k];
        }
        int count = 0;
        for (int j = 0; j <= arr[i - 1]; j++) {
            if (k - j >= 0) {

                count = ((count % mod) + (jump(i - 1, k - j) % mod)) % mod;
            }
            // count += jump(i + 1, k - j);
        }

        // return count;
        if (k == 0) {
            return dp[i][k] = count;
        }
        return dp[i][k] = dp[i][k - 1] + count;
    }

}