package shcell.Algorithm;

public class T70ClimbingStairs {

	public static void main(String[] args) {
		// System.out.println(removeNthFromEnd2(1));
	}

	// 超时
	public int climbStairs1(int n) {
		if (n == 0 || n == 1)
			return 1;
		if (n < 0)
			return 0;
		return climbStairs1(n - 1) + climbStairs1(n - 2);
	}

	// O(n)空间，O(n)时间
	public int climbStairs2(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int[] aux = new int[n];
		aux[0] = 1;
		aux[1] = 2;
		for (int i = 2; i < n; i++) {
			aux[i] = aux[i - 1] + aux[i - 2];
		}
		return aux[n - 1];
	}

	// O(1)空间，O(n)时间
	public int climbStairs3(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int one = 1;
		int two = 2;
		int three = 0;
		for (int i = 2; i < n; i++) {
			three = one + two;
			one = two;
			two = three;
		}
		return three;
	}

}
