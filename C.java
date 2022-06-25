import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        in.init(true);
        int n = in.readInt();
        int arrp[] = { 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7 };
        LinkedList<Integer> arr = (LinkedList<Integer>) Arrays.asList(1, 2, 3, 4, 5);

        for (int i = 0; i < n; i++) {
            sol(i + 1);
        }
        in.dinit();
    }

    private static void sol(int TESTCASE) throws IOException {
        int n = in.readInt();
        char c[] = in.readLine().toCharArray();
        int arr[] = new int[n];

        char prev = c[0];
        arr[0] = 0;
        for (int i = 1; i < c.length; i++) {

            if (c[i] == 'F') {
                arr[i] = arr[i - 1];
            } else {
                if (c[i] == 'X') {
                    if (prev == 'X' || prev == 'F')
                        arr[i] = arr[i - 1];
                    else {
                        arr[i] = arr[i - 1] + 1;
                        prev = 'O';
                    }
                    prev = 'X';
                }

                if (c[i] == 'O') {
                    if (prev == 'O' || prev == 'F')
                        arr[i] = arr[i - 1];
                    else {
                        arr[i] = arr[i - 1] + 1;
                        prev = 'X';
                    }
                    prev = 'O';
                }
            }

        }
        int arr2[] = new int[n];
        arr2[n - 1] = 0;
        prev = c[n - 1];
        for (int i = c.length - 2; i >= 0; i--) {

            if (c[i] == 'F') {
                arr2[i] = arr2[i + 1];
            } else {
                if (c[i] == 'X') {
                    if (prev == 'X' || prev == 'F')
                        arr2[i] = arr2[i + 1];
                    else {
                        arr2[i] = arr2[i + 1] + 1;
                        prev = 'O';
                    }
                    prev = 'X';
                }

                if (c[i] == 'O') {
                    if (prev == 'O' || prev == 'F')
                        arr2[i] = arr2[i + 1];
                    else {
                        arr2[i] = arr2[i + 1] + 1;
                        prev = 'X';
                    }
                    prev = 'O';
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (c[i] == 'F' || c[j] == 'F')
                    ans += getval(j, i, arr, arr2) - 1;
                else
                    ans += getval(j, i, arr, arr2);
            }
        }

        in.out.println("Case #" + TESTCASE + ": " + (ans % 1000000007));
    }

    static int getval(int a, int b, int arr[], int[] arr2) {
        return Math.min(Math.abs(arr[b] - arr[a]), Math.abs(arr2[a] - arr2[b]));
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
