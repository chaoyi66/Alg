package leetcode.part1;

public class T69Sqrt {
	// Integer.MAX_VALUE=2^31−1
	// System.out.println(1<<16*1<<16);
	// System.out.println((long)1<<16*1<<16);
	// 第一个乘法结果会超出int的范围，结果为0
	// 第二个才会有正确数值
	// Int 为4个Byte，共32位，除去第一个符号位，剩31位可以显示数值
	// long为8个Byte
	//
	// byte: 八位整数 -128——127，可用来节省内存的使用。
	// short: 16位整数 -32768——32,767，也比较省内存。
	// int: 32位整数 -2,147,483,648——2,147,483,647，一般来说整数都够用了
	// long: 64位整数 -9,223,372,036,854,775,808—— 9,223,372,036,854,775,807，一般不需要用
	// float: 32位浮点，如果浮点需要节省内存用这个。
	// Double: 64位浮点，一般非整数浮点可用这个。

	public static void main(String[] args) {
		System.out.println(mySqrt3(2147395599));
		System.out.println(1 << 16 * 1 << 16);
		System.out.println((long) 1 << 16 * 1 << 16);
	}

	// 暴力解法
	public static int mySqrt3(int x) {
		if (x < 0 || x > Integer.MAX_VALUE) {
			return -1;
		}
		int n = 0;
		for (; n * n <= x; n++) {
		}
		return n - 1;
	}

	// “或运算”特殊作用：
	// （1）常用来对一个数据的某些位置1。
	// 方法：找到一个数，对应X要置1的位，该数的对应位为1，其余位为零。此数与X相或可使X中的某些位置1。
	// 例：将X=10100000的低4位置1 ，用 X | 0000 1111 = 1010 1111即可得到。

	// “异或运算”的特殊作用：
	// （1）使特定位翻转找一个数，对应X要翻转的各位，该数的对应位为1，其余位为零，此数与X对应位异或即可。
	// 例：X=10101110，使X低4位翻转，用X ^ 0000 1111 = 1010 0001即可得到。
	// （2）与0相异或，保留原值 ，X ^ 0000 0000 = 1010 1110。

	// 位运算高级版
	public static int mySqrt(int x) {
		long ans = 0;
		long bit = 1L << 16;
		while (bit > 0) {
			ans |= bit;
			if (ans * ans > x) {
				ans ^= bit;
			}
			bit >>= 1;
		}
		return (int) ans;
	}

	// 二分法递归版
	public static int mySqrt1(int x) {
		if (x < 0) {
			return -1;
		}
		return findSqrt(x, 0, 1 << 16);
	}

	private static int findSqrt(int x, int lo, int hi) {
		if (lo > hi)
			return -1;
		int mid = lo + (hi - lo) / 2;
		if (x < (long) mid * mid) {
			return findSqrt(x, lo, mid - 1);
		} else if (x < (long) (mid + 1) * (mid + 1))
			return mid;
		else {
			return findSqrt(x, mid + 1, hi);
		}
	}

	// 二分法循环版
	public static int mySqrt2(int x) {
		if (x < 0) {
			return -1;
		}
		int lo = 0, hi = 1 << 16, mid = 0;
		while (lo < hi) {
			mid = lo + (hi - mid) / 2;
			if (x < (long) mid * mid)
				hi = mid - 1;
			else if (x < (long) (mid + 1) * (mid + 1))
				return mid;
			else {
				lo = mid + 1;
			}
		}
		return lo;
	}

}
