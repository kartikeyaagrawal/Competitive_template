import java.io.*;
import java.util.*;

class ch {
    char c;
    int val;

    ch(char c, int val) {
        this.c = c;
        this.val = val;
    }
}

public class A1 {
    public static void main(String[] args) throws IOException {
        in.init(false);

        int n = in.readInt();
        // 0/ == x
        // 1 == O
        for (int i = 0; i < n; i++) {
            sol(i);
        }
        in.dinit();

    }

    private static void sol(int testcase) throws IOException {
        int n = in.readInt();
        int row[][] = new int[n][2];
        int col[][] = new int[n][2];
        char arr[][] = new char[n][n];

        for (int i = 0; i < arr.length; i++) {
            String s = in.readLine();
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'O') {
                    row[i][1]++;
                    col[j][1]++;
                } else if (arr[i][j] == 'X') {
                    row[i][0]++;
                    col[j][0]++;
                }
            }
        }

        int rowmax = -1, colmax = -1;
        // row check
        int ans[] = new int[2];
        rowmax = ex(n, row, rowmax);
        colmax = ex(n, col, colmax);
        int count = 0;
        if (rowmax == colmax) {
            ans[0] = n - rowmax;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j] == 'X' || arr[i][j] == '.') {
                        if ((row[i][0] == rowmax && row[i][1] == 0) || (col[j][0] == colmax && col[j][1] == 0)) {
                            count++;
                        }
                    }
                }
            }

            // count = temp(n, row, rowmax, count);
            // count = temp(n, col, colmax, count);
            // if (n % 2 == 1 && row[n / 2][0] == rowmax && row[n / 2][1] == 0 && col[n /
            // 2][0] == colmax
            // && col[n / 2][1] == 0) {
            // ans[1] -= 1;
            // }
            ans[1] += count;
        } else {
            if (rowmax > colmax) {
                ans[0] = n - rowmax;
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[i][j] == 'X' || arr[i][j] == '.') {
                            if (row[i][0] == rowmax && row[i][1] == 0) {
                                count++;
                            }
                        }
                    }
                }
                ans[1] = count;
            } else {
                ans[0] = n - colmax;
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[i][j] == 'X' || arr[i][j] == '.') {
                            if (col[j][0] == colmax || col[j][1] == 0) {
                                count++;
                            }
                        }
                    }
                }
                ans[1] = count;
            }
        }

        if (rowmax == colmax && colmax == -1) {
            System.out.println("Case #" + (testcase + 1) + ": Impossible");
        } else {

            System.out.println("Case #" + (testcase + 1) + ": " + ans[0] + " " + ans[1]);
        }

    }

    private static int temp(int n, int[][] arr, int max, int count) {
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == max && arr[i][1] == 0) {
                count++;
            }
        }
        return count;
    }

    private static int ex(int n, int[][] arr, int max) {
        for (int i = 0; i < n; i++) {
            if (arr[i][0] > max && arr[i][1] == 0) {
                max = arr[i][0];
            }
        }
        return max;
    }
}

// class in {

// static BufferedReader br;
// static PrintWriter out;
// static StringTokenizer st;

// public static void init() throws IOException {
// br = new BufferedReader(new InputStreamReader(System.in));
// out = new PrintWriter(new OutputStreamWriter(System.out));
// // br = new BufferedReader(new FileReader("in.txt"));
// // out = new PrintWriter(new FileWriter("out.txt"));

// // out.close();
// }

// static int[] arr(int n) throws IOException {
// int arr[] = new int[n];
// for (int i = 0; i < n; i++) {
// arr[i] = in.readInt();

// }
// return arr;

// }

// static void print(String s) {
// out.println(s);
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
