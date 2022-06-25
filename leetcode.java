import java.util.*;
import java.io.*;

// import java.security.acl.Owner;

class Result {

    /*
     * Complete the 'minPrice' function below.
     *
     * The function is expected to return an INTEGER. The function accepts
     * 2D_INTEGER_ARRAY cost as parameter.
     */
    static int dp[];
    static int n;

    public static int minPrice(List<List<Integer>> cost) {
        // Write your code here
        n = cost.size();
        dp = new int[n];
        int ans = jump(0, cost);

    }

    private static int jump(int i, List<List<Integer>> cost) {
        if(i==n)
        {
            return  0;
        }
        int sum =  0;
        sum = Math.min(cost.get(i).get(0)+jump(i+1,cost), Math.min(cost.get(i).get(1)+jump(i+1,cost), cost.get(i).get(2)+jump(i+1,cost)))
        return sum;
    }

}

class leetcode {

    public static void main(String[] args) throws IOException {
        in.init(true);
        Solution sol = new Solution();

        String s = "ADOBECODEBANC";
        String t = "ABC";
        int a[] = get();
        int b[] = get();
        // int arr[][] = get2d(a.length / 2, 2, a);
        System.out.println("------------------------------------");
        System.out.println(sol.canCompleteCircuit(a, b));

        in.dinit();

    }

    static int[] get() throws IOException {
        char s[] = in.readLine().toCharArray();
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        int n = s.length;
        int val = 0;
        boolean ff = false;
        while (i != n) {
            if (Character.isDigit(s[i])) {
                val = val * 10 + (s[i] - '0');
                ff = true;
            } else {
                if (ff == true) {
                    arr.add(val);
                    val = 0;
                    ff = false;
                }
            }
            i++;
        }
        // int a[] =
        return arr.stream().mapToInt(r -> r).toArray();

    }

    static int[][] get2d(int row, int col, int arr[]) {
        int k = 0;
        int ans[][] = new int[row][col];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = arr[k++];
            }
        }
        return ans;
    }

}
