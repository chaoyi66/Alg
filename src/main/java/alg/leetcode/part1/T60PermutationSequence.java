package alg.leetcode.part1;

import java.util.LinkedList;
import java.util.List;

public class T60PermutationSequence {

	public static void main(String[] args) {
		System.out.println(getPermutation(3, 5));
	}

	public static String getPermutation(int n, int k) {

		k = k - 1; // 此步骤为必须，考虑第一个位置，必然依次选择list里的0位置，所以k应该从0算起

		List<Integer> list = new LinkedList<>();
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			list.add(i);
			factorial *= i;
		}
		StringBuilder sb = new StringBuilder();
		int tmp;
		while (n > 0) {
			factorial = factorial / n--;
			tmp = k / factorial;
			sb.append(list.get(tmp));
			list.remove(tmp);
			k = k % factorial;
		}
		return sb.toString();

	}

}
