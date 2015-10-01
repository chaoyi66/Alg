package shcell.Algorithm;

/* There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity 
 * should be O(log (m+n)).*/

public class T4MedianOfTwoSortedArrays {

	// 暴力解法，先融合数组，再取中位值
	public static double findMedianSortedArrays1(double[] nums1, double[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		double[] a = new double[m + n];
		int i1 = 0, i2 = 0, i = 0;
		while (i < (m + n) / 2 + 1) {
			if (i1 < m && i2 < n) {
				if (nums1[i1] < nums2[i2]) {
					a[i++] = nums1[i1++];
				} else {
					a[i++] = nums2[i2++];
				}
			} else if (i1 == m) {
				a[i++] = nums2[i2++];
			} else if (i2 == n) {
				a[i++] = nums1[i1++];
			}
		}
		if ((m + n) % 2 == 0)
			return (a[(m + n) / 2 - 1] + a[(m + n) / 2]) / 2;
		else
			return a[(m + n) / 2];

	}

	// 暴力解法，先融合数组，再取中位值
	public static double findMedianSortedArrays(double[] nums1, double[] nums2) {
		int m = nums1.length, n = nums2.length;
		if ((n + m) % 2 == 1)
			return findKthSortedArrays(nums1, 0, m, nums2, 0, n, (n + m) / 2 + 1);
		else
			return (findKthSortedArrays(nums1, 0, m, nums2, 0, n, (n + m) / 2 + 1)
					+ findKthSortedArrays(nums1, 0, m, nums2, 0, n, (n + m) / 2)) / 2.0;

	}

	private static double findKthSortedArrays(double A[], int astart, int aend, double B[], int bstart, int bend,
			int k) {
		int m = aend - astart, n = bend - bstart;
		if (m < n) {
			return findKthSortedArrays(B, bstart, bend, A, astart, aend, k);
		}
		if (n == 0)
			return A[astart + k - 1];
		if (k == 1)
			return Math.min(A[astart], B[bstart]);

		int pb = Math.min(k / 2, n), pa = k - pb;
		if (A[astart + pa - 1] > B[bstart + pb - 1])
			return findKthSortedArrays(A, astart, aend, B, bstart + pb, bend, k - pb);
		else if (A[astart + pa - 1] < B[bstart + pb - 1])
			return findKthSortedArrays(A, astart + pa, aend, B, bstart, bend, k - pa);
		else
			return A[astart + pa - 1];
	}
}
