import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        in.init(false);
        int n = in.readInt();
        for (int i = 0; i < n; i++) {
            sol(i + 1);
        }
        in.dinit();
    }

    private static void sol(int TestCase) throws IOException {
        int n = in.readInt();
        int m = in.readInt();
        int A = in.readInt();
        int B = in.readInt();
        int arr[][] = new int[n][m];
        for (int[] a : arr) {
            Arrays.fill(a, 1000);
        }
        // general case
        int sumDone = m;
        for (int i = 0; i < m; i++) {
            arr[n - 1][i] = 1;
        }
        A = A - m;
        B = B - m;
        for (int i = 1; i < n - 1; i++) {
            arr[i][0] = 1;
            arr[i][m - 1] = 1;

        }
        A = A - (n - 2);
        B = B - (n - 2);
        arr[0][0] = A;
        arr[0][m - 1] = B;
        if (A < 1 || B < 1) {
            in.out.println("Case #" + TestCase + ": Impossible");
            return;
        }
        in.out.println("Case #" + TestCase + ": Possible");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                in.out.print(arr[i][j] + " ");
            }
            in.out.println();
        }
    }

    private static int count(char[] ans) {
        int count = 0;
        for (int i = 1; i < ans.length; i++) {
            if (ans[i] != ans[i - 1]) {
                count++;
            }
        }
        return count;
    }
}

class in {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void init(boolean test) throws IOException {
        if (test == true) {
            br = new BufferedReader(new FileReader("in"));
            out = new PrintWriter(new OutputStreamWriter(System.out));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
        }

    }

    public static void init(String in) throws IOException {

        br = new BufferedReader(new FileReader(in));
        out = new PrintWriter(new FileWriter("out.txt"));

        // out.close();
    }

    // public static void init(boolean f) throws IOException {
    // if (f == true) {
    // br = new BufferedReader(new FileReader(in));
    // out = new PrintWriter(new FileWriter("out.txt"));
    // }

    // else {
    // br = new BufferedReader(new InputStreamReader(System.in));
    // out = new PrintWriter(new OutputStreamWriter(System.out));
    // }
    // // out.close();
    // }

    static void print(String s) {
        out.println(s);
    }

    static int[] arr(int n) throws IOException {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.readInt();

        }
        return arr;

    }

    public static void dinit() throws IOException {
        br.close();

        out.close();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
