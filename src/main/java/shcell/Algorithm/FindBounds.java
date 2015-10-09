package shcell.Algorithm;

import java.util.Arrays;
import java.util.Random;

public class FindBounds {
	static int length = (int) 2e8;
	static int[] a = new int[length];

	/*
	 * 排序好的大数组中找出指定数值的位置上下界 找不到该数则返回-1
	 */
	static {
		// System.out.println("Memory: " + Runtime.getRuntime().maxMemory());

		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(10);
		}
		long t1 = System.currentTimeMillis();
		Arrays.sort(a);
		long t2 = System.currentTimeMillis();
		System.out.println("Sort time cost: " + (t2 - t1));
		// for (int x : a) {
		// System.out.print(x + " ");
		// }
		// System.out.println();
	}

	public static void main(String[] args) {

		long sum1 = 0;
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < a.length; i++) {
			sum1 += a[i];
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Sum = " + sum1);
		System.out.println("Time1 cost: " + (t2 - t1));

		long sum2 = 0;
		long t3 = System.currentTimeMillis();
		int[] b = new int[100];
		for (int i = 0; i < a.length; i++) {
			b[a[i]]++;
		}
		for (int i = 0; i < b.length; i++) {
			sum2 += b[i] * i;
		}
		long t4 = System.currentTimeMillis();
		System.out.println("Sum = " + sum2);
		System.out.println("sum1==sum2 :" + (sum1 == sum2));
		System.out.println("Time2 cost: " + (t4 - t3));

		long sum3 = 0;
		long t5 = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			int lb = lowwer_bound(i, 0, a.length - 1);
			if (lb != -1) {
				int hb = upper_bound(i, 0, a.length - 1);
				sum3 += i * (hb - lb + 1);
			}
		}
		long t6 = System.currentTimeMillis();
		System.out.println("Sum = " + sum3);
		System.out.println("sum1==sum3 :" + (sum1 == sum3));
		System.out.println("Time3 cost: " + (t6 - t5));

		// System.out.println("5的位置：" + binary_search(5, 0, 9));
		// System.out.println("5的下届：" + lowwer_bound(5, 0, 9));
		// System.out.println("5的上界：" + upper_bound(5, 0, 9));

	}

	@SuppressWarnings("unused")
	private static int binary_search(int val, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (a[mid] > val) {
			return binary_search(val, low, mid - 1);
		} else if (a[mid] < val) {
			return binary_search(val, mid + 1, high);
		} else {
			return mid;
		}
	}

	private static int lowwer_bound(int val, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (a[mid] > val) {
			return lowwer_bound(val, low, mid - 1);
		} else if (a[mid] < val) {
			return lowwer_bound(val, mid + 1, high);
		} else {
			if (mid > 0 && a[mid - 1] == val) {
				return lowwer_bound(val, low, mid - 1);
			} else
				return mid;
		}

	}

	private static int upper_bound(int val, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (a[mid] > val) {
			return upper_bound(val, low, mid - 1);
		} else if (a[mid] < val) {
			return upper_bound(val, mid + 1, high);
		} else {
			if (mid < a.length - 1 && a[mid + 1] == val) {
				return upper_bound(val, mid + 1, high);
			} else
				return mid;
		}

	}
}
