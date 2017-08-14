package alg.leetcode.part2;

import java.util.Arrays;
import java.util.HashSet;

public class T326PowerOfThree {

	public static void main(String[] args) {
        int i = Integer.parseInt("1e",16);  
		System.out.println(i);

	}

	public boolean isPowerOfThree(int n) {
		return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree(n / 3)));
	}

	public boolean isPowerOfThree1(int n) {
		if (n > 1)
			while (n % 3 == 0)
				n /= 3;
		return n == 1;
	}

	public boolean isPowerOfThree2(int n) {
		HashSet<Integer> set = new HashSet<>(
				Arrays.asList(1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441,
						1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467));
		return set.contains(n);
	}

	public boolean isPowerOfThree3(int n) {
		return Integer.toString(n, 3).matches("10*");
	}

}
