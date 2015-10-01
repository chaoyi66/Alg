package shcell.Algorithm;

/* There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity 
 * should be O(log (m+n)).*/

public class T5LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		longestPalindrome1("abb");
		System.out.println(longestPalindrome1("abb"));
	}

	// 暴力解法，轮流测试每个位置作为中心时得到的最长回文
	public static String longestPalindrome1(String s) {
		String longest = "";
		for (int i = 0; i < s.length(); i++) {
			String tmp = getPalindrome(s, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;

	}

	public static String getPalindrome(String s, int p) {
		// 奇数回文字符串
		int start1 = p - 1, end1 = p + 1;
		while (start1 >= 0 && end1 < s.length() && s.charAt(start1) == s.charAt(end1)) {
			start1--;
			end1++;
		}
		// 偶数回文1
		int start2 = p, end2 = p + 1;
		while (start2 >= 0 && end2 < s.length() && s.charAt(start2) == s.charAt(end2)) {
			start2--;
			end2++;
		}
//		// 偶数回文2
//		int start3 = p - 1, end3 = p;
//		while (start3 >= 0 && end3 < s.length() && s.charAt(start3) == s.charAt(end3)) {
//			start3--;
//			end3++;
//		}
		int len1 = end1 - start1;
		int len2 = end2 - start2;
//		int len3 = end3 - start3;
		if (len1 >= len2 )
			return s.substring(start1 + 1, end1);
		else if (len2 >= len1 )
			return s.substring(start2 + 1, end2);
//		else if (len3 >= len1 && len3 >= len2)
//			return s.substring(start3 + 1, end3);
		else {
			return "";
		}
	}
}
