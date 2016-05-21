package part2;

public class T263UglyNumber {

	public static void main(String[] args) {
		System.out.println();
	}

	public boolean isUgly(int num) {
		if (num == 1)
			return true;
		if (num == 0)
			return false;
		while (num % 2 == 0)
			num = num / 2;
		while (num % 3 == 0)
			num = num / 3;
		while (num % 5 == 0)
			num = num / 5;
		return num == 1;
	}

	public boolean isUgly1(int num) {
		if (num > 0)
			for (int i : new int[] { 2, 3, 5 }) {
				while (num % i == 0) {
					num /= i;
				}
			}
		return num == 1;
	}

}
