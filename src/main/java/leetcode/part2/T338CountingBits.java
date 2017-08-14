package leetcode.part2;

public class T338CountingBits {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		int[] r = countBits1(5);
		System.out.println();
	}

	public static int[] countBits(int num) {
		if (num == 0)
			return new int[] { 0 };
		if (num == 1)
			return new int[] { 0, 1 };
		int[] result = new int[num + 1];
		int exp = 0;
		result[0] = 0;
		result[1] = 1;
		for (int i = 2; i <= num; i++) {
			int res = (int) (i % (Math.pow(2, exp)));
			if (res == 0) {
				exp++;
			}
			result[i] = result[res] + 1;
		}
		return result;

	}

	// An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
	public static int[] countBits1(int num) {
		int[] f = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			System.out.println("i= " + i);
			System.out.println("i>>1=" + (i >> 1));
			System.out.println("i&1=" + (i & 1));
			f[i] = f[i >> 1] + (i & 1);
		}

		return f;
	}
}
