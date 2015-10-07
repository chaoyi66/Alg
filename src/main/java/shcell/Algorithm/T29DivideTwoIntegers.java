package shcell.Algorithm;

public class T29DivideTwoIntegers {

	 public static void main(String[] args) {
		 System.out.println(Integer.toBinaryString(Integer.MIN_VALUE-1));
		 System.out.println(divide(1000, 3));
		 System.out.println((1<<3)|(1<<1));
	 }

	public static int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		} else if (divisor == 1) {
			return dividend;
		} else if (divisor == -1) {
			return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;
		} else {
			final boolean negative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

			long ldividend = Math.abs((long) dividend);
			final long ldivisor = Math.abs((long) divisor);
			int result = 0;

			for (int bit = Integer.SIZE - 1; bit >= 0 && ldividend >= ldivisor; --bit) {
				if (ldividend >= (ldivisor << bit)) {
					ldividend -= ldivisor << bit;
					result |= 1 << bit;
				}
			}

			return negative ? -result : result;
		}
	}
	
	public static int divide1(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		} else if (divisor == 1) {
			return dividend;
		} else if (divisor == -1) {
			return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;
		} else {
			final boolean negative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

			long ldividend = Math.abs((long) dividend);
			final long ldivisor = Math.abs((long) divisor);
			int result = 0;

			for (int bit = Integer.SIZE - 1; bit >= 0 && ldividend >= ldivisor; --bit) {
				if (ldividend >= (ldivisor << bit)) {
					ldividend -= ldivisor << bit;
					result |= 1 << bit;
				}
			}

			return negative ? -result : result;
		}
	}
}
