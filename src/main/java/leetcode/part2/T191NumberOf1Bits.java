package leetcode.part2;

public class T191NumberOf1Bits {

	public static void main(String[] args) {
		System.out.println(hammingWeight1(7));
		System.out.println(1 & 4);
		System.out.println(~1);

	}

	public static int hammingWeight(int n) {
		int ans = 0;
		while (n >> 1 >= 1) {
			ans = n % 2 == 0 ? ans : ans + 1;
			n = n >> 1;
		}
		ans += n;
		return ans;
	}

	// 思路一：
	//
	// 1、n&1 可得到最低位的数字，然后加到count变量中即可
	//
	// 2、n>>>1，注意是三个>不是两个>，三个的是逻辑移位，两个的是算术移位（Java中的定义）
	//
	// 缺点就是：有多少位就要需要移动多少次
	public static int hammingWeight1(int n) {
		int ones = 0;
		while (n != 0) {
			ones = ones + (n & 1);
			n = n >>> 1;
		}
		return ones;
	}

	// 解法二：此解关键在于明白n&(n-1)会n最后一位1消除，这样循环下去就可以求出n的位数中为1的个数
	
	// 思路二：
	//
	// 1、假设n＝ 1111000111000 那 n-1 = 1111000110111, (n-1) & n =
	// 1111000110000，刚好把最后一个1给干掉了。也就是说， (n-1)&n
	// 刚好会从最后一位开始，每次会干掉一个1.这样速度就比下面的快了。有几个1，执行几次。

	public static int hammingWeight2(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

}
