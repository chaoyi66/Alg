package shcell.Algorithm;

public class T28ImplementStrStr {

	public static void main(String[] args) {
		System.out.println(strStr("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
	}

	// 暴力解法
	public static int strStr1(String haystack, String needle) {
		int len1 = haystack.length();
		int len2 = needle.length();
		if (len1 < len2) {
			return -1;
		}
		if (len1 == len2) {
			return haystack.equals(needle) ? 0 : -1;
		}
		for (int i = 0; i < len1 - len2 + 1; i++) {
			int j = 0;
			while (j < len2 && haystack.charAt(i + j) == needle.charAt(j)) {
				j++;
			}
			if (j == len2)
				return i;
		}
		return -1;

	}

	// 暴力解法2
	public static int strStr2(String haystack, String needle) {
		int len1 = haystack.length();
		int len2 = needle.length();
		if (len1 < len2) {
			return -1;
		}
		if (len1 == len2) {
			return haystack.equals(needle) ? 0 : -1;
		}
		int i = 0, j = 0;
		while (i < len1 && j < len2) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
			if (j == len2)
				return i - j;
		}
		return -1;

	}

	// KMP方法
	public static int strStr(String text, String pattern) {
		int tLen = text.length();
		int pLen = pattern.length();

		int[] next = new int[pLen];
		for (int i = 0; i < pLen; i++) {
			for (int j = 1; j < i; j++) {
				if (pattern.substring(j, i).equals(pattern.substring(0, i - j))) {
					next[i] = i - j;
				}
			}
		}
		next[0] = -1;
		int i = 0, j = 0;
		while (i < tLen && j < pLen) {
			// ①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
			if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				// ②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
				// next[j]即为j所对应的next值
				j = next[j];
			}
		}
		if (j == pLen)
			return i - j;
		else
			return -1;

	}

}
