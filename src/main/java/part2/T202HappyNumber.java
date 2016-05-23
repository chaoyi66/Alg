package part2;

import java.util.HashSet;

public class T202HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy1(2));
	}

	public static boolean isHappy(int n) {
		return isHappy(n, new HashSet<>());
	}

	public static boolean isHappy(int n, HashSet<Integer> set) {
		System.out.println(n);
		if (n == 1)
			return true;
		if (set.contains(n))
			return false;
		set.add(n);
		int tmp = n;
		n = 0;
		while (tmp != 0) {
			n += (tmp % 10) * (tmp % 10);
			tmp = tmp / 10;
		}
		return isHappy(n, set);
	}

	public static boolean isHappy1(int n) {
		HashSet<Integer> set = new HashSet<>();
		while (set.add(n)) {
			System.out.println(n);
			int tmp = n;
			n = 0;
			while (tmp != 0) {
				n += (tmp % 10) * (tmp % 10);
				tmp = tmp / 10;
			}
			if (n == 1) {
				return true;
			}
		}
		return false;
	}

}
