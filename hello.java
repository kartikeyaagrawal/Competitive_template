import java.util.*;

class hello {
	public static void main(String args[]) {
		int max = 0;
		for (int i =0 ; i <= 100; i++) {
			for (int j = i; j <= 100; j++) {
				max = Math.max(max, j % i);
				System.out.println(j % i + " " + j + "%" + i);
			}
		}
		System.out.println(max);

	}
}