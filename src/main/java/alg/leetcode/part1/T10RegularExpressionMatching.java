package alg.leetcode.part1;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

/* Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true 
*/

public class T10RegularExpressionMatching {

	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 };
		int[] removed = ArrayUtils.removeElement(intArray, 6);//create a new array
		System.out.println(Arrays.toString(removed));
	}

	public static boolean isMatchNoStar(String s, String p) {
		if (s.length() != p.length()) {
			return false;
		}
		char[] sa = s.toCharArray();
		char[] pa = p.toCharArray();
		int i = 0;

		while (i < sa.length && (sa[i] == pa[i] || pa[i] == '.')) {
			i++;
		}
		if (i == sa.length)
			return true;
		else {
			return false;
		}

	}

	public static boolean isMatchOnlyStar(String s, String p) {

		char[] sa = s.toCharArray();
		char[] pa = p.toCharArray();
		int i = 0;

		while (i < pa.length - 1) {

			i++;
		}
		if (i == sa.length)
			return true;
		else {
			return false;
		}

	}

	public static boolean isMatch_short(String s, String p) {

		if (p.length() == 0)
			return s.length() == 0;

		// p's length 1 is special case
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
				return false;
			return isMatch_short(s.substring(1), p.substring(1));

		} else {
			int len = s.length();

			int i = -1;
			while (i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
				if (isMatch_short(s.substring(i + 1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}

	public boolean isMatch_clean(String s, String p) {
		// base case
		if (p.length() == 0) {
			return s.length() == 0;
		}

		// special case
		if (p.length() == 1) {

			// if the length of s is 0, return false
			if (s.length() < 1) {
				return false;
			}

			// if the first does not match, return false
			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			}

			// otherwise, compare the rest of the string of s and p.
			else {
				return isMatch_clean(s.substring(1), p.substring(1));
			}
		}

		// case 1: when the second char of p is not '*'
		if (p.charAt(1) != '*') {
			if (s.length() < 1) {
				return false;
			}
			if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			} else {
				return isMatch_clean(s.substring(1), p.substring(1));
			}
		}

		// case 2: when the second char of p is '*', complex case.
		else {
			// case 2.1: a char & '*' can stand for 0 element
			if (isMatch_clean(s, p.substring(2))) {
				return true;
			}

			// case 2.2: a char & '*' can stand for 1 or more preceding element,
			// so try every sub string
			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch_clean(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}
}
