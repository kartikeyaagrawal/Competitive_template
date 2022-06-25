import java.io.*;
import java.util.*;

public class A {
    static int k;

    public static void main(String[] args) throws IOException {
        in.init(true);
        int n = in.readInt();

        for (int i = 0; i < n; i++) {
            sol(i + 1);
        }
        in.dinit();
    }

    private static void sol(int TESTCASE) throws IOException {
        int n = in.readInt();
        k = in.readInt();
        int arr[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.readInt();
            sum += arr[i];
        }
        int dp[][] = new int[n][n];
        int as = jump(0, 0);
        in.out.println("Case #" + TESTCASE + ": " + count);
    }

    private static int jump(int i, int left) {
        if(left)
        return 0;
    }
}

// class in {

// static BufferedReader br;
// static PrintWriter out;
// static StringTokenizer st;

// public static void init(boolean test) throws IOException {
// if (test == true) {
// br = new BufferedReader(new FileReader("in"));
// out = new PrintWriter(new OutputStreamWriter(System.out));
// } else {
// br = new BufferedReader(new InputStreamReader(System.in));
// out = new PrintWriter(new OutputStreamWriter(System.out));
// }

// }

// public static void init(String in) throws IOException {

// br = new BufferedReader(new FileReader(in));
// out = new PrintWriter(new FileWriter("out.txt"));

// // out.close();
// }

// // public static void init(boolean f) throws IOException {
// // if (f == true) {
// // br = new BufferedReader(new FileReader(in));
// // out = new PrintWriter(new FileWriter("out.txt"));
// // }

// // else {
// // br = new BufferedReader(new InputStreamReader(System.in));
// // out = new PrintWriter(new OutputStreamWriter(System.out));
// // }
// // // out.close();
// // }

// static void print(String s) {
// out.println(s);
// }

// static int[] arr(int n) throws IOException {
// int arr[] = new int[n];
// for (int i = 0; i < n; i++) {
// arr[i] = in.readInt();

// }
// return arr;

// }

// public static void dinit() throws IOException {
// br.close();

// out.close();
// }

// static String next() throws IOException {
// while (st == null || !st.hasMoreTokens())
// st = new StringTokenizer(br.readLine().trim());
// return st.nextToken();
// }

// static long readLong() throws IOException {
// return Long.parseLong(next());
// }

// static int readInt() throws IOException {
// return Integer.parseInt(next());
// }

// static double readDouble() throws IOException {
// return Double.parseDouble(next());
// }

// static char readCharacter() throws IOException {
// return next().charAt(0);
// }

// static String readLine() throws IOException {
// return br.readLine().trim();
// }
// }
