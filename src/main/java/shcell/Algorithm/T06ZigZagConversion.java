package shcell.Algorithm;

/* There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity 
 * should be O(log (m+n)).*/

public class T06ZigZagConversion {

	public static void main(String[] args) {

	}

	public static String convert1(String s, int numRows) {
		if (numRows == 1)
			return s;
		else {
			StringBuilder[] sb = new StringBuilder[numRows];
			for (int i = 0; i < sb.length; i++) {
				sb[i] = new StringBuilder();
			}
			for (int i = 0; i < s.length(); i++) {
				int n = i % (2 * numRows - 2);
				if (n >= 0 && n < numRows ) {
					sb[n].append(s.charAt(i));
				} else if (numRows > 2) {
					sb[2 * numRows - n - 2].append(s.charAt(i));
				}
			}
			for (int i = 1; i < numRows; i++) {
				sb[0].append(sb[i]);
			}
			return sb[0].toString();
		}

	}

	public static String convert(String s, int nRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuffer[] sb = new StringBuffer[nRows];
		for (int i = 0; i < sb.length; i++)
			sb[i] = new StringBuffer();

		int i = 0;
		while (i < len) {
			for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
				sb[idx].append(c[i++]);
			for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely
																	// up
				sb[idx].append(c[i++]);
		}
		for (int idx = 1; idx < sb.length; idx++)
			sb[0].append(sb[idx]);
		return sb[0].toString();
	}

}
