package leetcode.part1;

/* Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i 
 * is at (i, ai) and (i, 0). Find two lines, which together with 
 * x-axis forms a container, such that the container contains the 
 * most water.
 * 
 * Note: You may not slant the container.
*/

public class T14LonggestCommonPrefix {

	public static void main(String[] args) {

	}

	// 暴力解法
	public static String longestCommonPrefix1(String[] strs) {
		if (strs.length == 0)
			return "";
		String commonPrefix = strs[0];
		for (String str : strs) {
			commonPrefix = getCommonPrefix(commonPrefix, str);
		}
		return commonPrefix;

	}

	public static String getCommonPrefix(String str1, String str2) {
		if (str1 == null || str2 == null)
			return null;
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < c1.length && i < c2.length && c1[i] == c2[i]) {
			sb.append(c1[i]);
			i++;
		}
		return sb.toString();

	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String str0 = strs[0];
		for (int i = 0; i < strs[0].length(); i++) {
			char c = str0.charAt(i);
			for (String s : strs) {
				if (s.length() < i+1 || s.charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}

}
