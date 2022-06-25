import java.io.*;
import java.util.*;

public class b1 {
    public static void main(String[] args) throws IOException {
        in.init("gold_mine_chapter_1_input.txt");
        // in.init(false);
        int n = in.readInt();
        // 0/ == x
        // 1 == O
        for (int i = 0; i < n; i++) {
            sol(i);
        }
        in.dinit();

    }

    @SuppressWarnings({ "unchecked" })
    private static void sol(int testcase) throws IOException {
        // initalization
        int nodes = in.readInt();

        LinkedList<Integer> arr[] = new LinkedList[nodes];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new LinkedList<Integer>();

        }
        int val[] = new int[nodes];
        for (int i = 0; i < val.length; i++) {
            val[i] = in.readInt();
        }
        for (int i = 0; i < nodes - 1; i++) {
            int a = in.readInt() - 1;
            int b = in.readInt() - 1;
            arr[a].add(b);
            arr[b].add(a);

        }
        if (arr[0].size() == 0) {
            print(val[0], testcase);
            return;
        }
        int ans[] = new int[arr[0].size()];

        // initalization
        int count = 0;
        int visited[] = new int[nodes];
        visited[0] = 1;
        for (int i : arr[0]) {
            ans[count++] = getmaxval(arr, i, val, visited);
        }
        Arrays.sort(ans);
        if (ans.length == 1) {
            print(ans[0] + val[0], testcase);

        } else {
            print(ans[ans.length - 1] + ans[ans.length - 2] + val[0], testcase);

        }

    }

    static void print(int n, int testcase) {
        in.out.println("Case #" + (testcase + 1) + ": " + n);
        // System.out.println();
    }

    private static int getmaxval(LinkedList<Integer>[] arr, int index, int[] val, int[] visited) {
        if (arr[index].size() == 0)
            return val[index];

        visited[index] = 1;
        int max = 0;

        for (int temp : arr[index]) {
            if (visited[temp] == 0)

                max = Math.max(getmaxval(arr, temp, val, visited), max);
        }

        return val[index] + max;

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
