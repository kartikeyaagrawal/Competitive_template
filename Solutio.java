
// import java.io.IOException;
import java.io.*;
import java.util.*;

public class Solutio {
    public static void main(String[] args) throws IOException {
        in.init(true);
        int n = in.readInt();

        for (int i = 0; i < n; i++) {
            sol(i + 1);
        }
        in.dinit();
    }

    private static void sol(int i) throws IOException {
        int n = in.readInt();
        char arr[] = in.readLine().toCharArray();

        int lr[] = new int[n];
        int rl[] = new int[n];
        int fill = Integer.MAX_VALUE;
        for (int j = 0; j < rl.length; j++) {
            if (arr[j] == '1') {
                fill = j;
            }
            lr[j] = fill;
        }
        fill = Integer.MAX_VALUE;
        for (int j = n - 1; j >= 0; j--) {
            if (arr[j] == '1') {
                fill = j;
            }
            rl[j] = fill;
        }
        int ans = 0;
        for (int j = 0; j < rl.length; j++) {
            ans += Math.min(Math.abs(j - lr[j]), Math.abs(j - rl[j]));

        }
        print(i, ans);
    }

    static void print(int test, int ans) {
        System.out.println("Case #" + test + ": " + ans);
    }
}
