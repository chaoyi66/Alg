package leetcode.part2;

public class T231PowerOfTwo {

	public static void main(String[] args) {
		System.out.println();
	}

	public boolean isPowerOfTwo(int n) {
		return n > 0 && Integer.bitCount(n) == 1;
	}

	public boolean isPowerOfTwo1(int n) {
		return ((n & (n - 1)) == 0 && n > 0);
	}

}
