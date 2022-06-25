import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        in.init(false);
        int n = in.readInt();
        for (int i = 0; i < n; i++) {
            sol();
        }
        in.dinit();
    }

    private static void sol() throws IOException {
        int n = in.readInt();
        int arr[] = in.arr(n);
        for (int i : arr) {
            System.out.println(Integer.toBinaryString(i));
        }
    }
}
