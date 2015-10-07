package shcell.Algorithm;

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
		System.out.println(mySqrt2(2147395599));
		System.out.println(1 << 16 * 1 << 16);
		System.out.println((long) 1 << 16 * 1 << 16);
	}

	// 暴力解法
	public static int mySqrt1(int x) {
		if (x < 0 || x > Integer.MAX_VALUE) {
			return -1;
		}
		int n = 0;
		for (; n * n <= x; n++) {
		}
		return n - 1;
	}

	// 二分法递归版
	public static int mySqrt(int x) {
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
