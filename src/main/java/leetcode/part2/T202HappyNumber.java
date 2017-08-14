package leetcode.part2;

import java.util.HashSet;

public class T202HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy1(2));
	}

	public static boolean isHappy(int n) {
		return isHappy(n, new HashSet<>());
	}

	// 递归
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

	// 循环
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

	// 看成一个检查链表环的问题，可以用O(1)空间解决
	public boolean isHappy2(int n) {
		int x = n;
		int y = n;
		while (x > 1) {
			x = cal(x);
			if (x == 1)
				return true;
			y = cal(cal(y));
			if (y == 1)
				return true;

			if (x == y)
				return false;
		}
		return true;
	}

	public int cal(int n) {
		int x = n;
		int s = 0;
		while (x > 0) {
			s = s + (x % 10) * (x % 10);
			x = x / 10;
		}
		return s;
	}

}
