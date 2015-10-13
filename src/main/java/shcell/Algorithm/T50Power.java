package shcell.Algorithm;

public class T50Power {

	public static void main(String[] args) {
		System.out.println(myPow(1, -2147483648));
	}

	public static double myPow(double x, int n) {
		if (x == 0)
			return 0;
		if (n == 0)
			return 1.0;
		if (n < 0) {
			if (n == Integer.MIN_VALUE)
				// Integer.MAX_VALUE!=-Integer.MIN_VALUE
				return 1 / x * myPow(x, -(n + 1));
			return myPow(1 / x, -n);
		}
		return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);

	}

}
