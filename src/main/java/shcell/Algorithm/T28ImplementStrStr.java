package shcell.Algorithm;

public class T28ImplementStrStr {

	public static void main(String[] args) {
//		System.out.println(strStr("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
//		System.out.println(5<<1);
		System.out.println(Integer.MAX_VALUE-(1<<(Integer.SIZE-1)));
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
		if (tLen < pLen) {
			return -1;
		}
		if (tLen == pLen) {
			return text.equals(pattern) ? 0 : -1;
		}
		// 计算next数组
		int[] next = new int[pLen];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while (j < pLen - 1) {
			// p[k]表示前缀，p[j]表示后缀
			if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
				++k;
				++j;
				next[j] = k;
			} else {
				k = next[k];
			}
		}
		// 字符串匹配
		int i = 0, jj = 0;
		while (i < tLen && jj < pLen) {
			// ①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
			if (jj == -1 || text.charAt(i) == pattern.charAt(jj)) {
				i++;
				jj++;
			} else {
				// ②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
				// next[j]即为j所对应的next值
				jj = next[jj];
			}
		}
		if (jj == pLen)
			return i - jj;
		else
			return -1;

	}

}
