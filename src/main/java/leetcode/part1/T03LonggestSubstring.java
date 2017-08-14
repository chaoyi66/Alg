package leetcode.part1;

import java.util.HashMap;
import java.util.HashSet;

/*Given a string, find the length of the longest substring without
 *  repeating characters. For example, the longest substring without 
 *  repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.*/

public class T03LonggestSubstring {

	// 暴力解法
	public static int lengthOfLongestSubstring1(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			HashSet<Character> hs = new HashSet<>();
			for (int j = i; j < s.length(); j++) {
				if (hs.contains(s.charAt(j))) {
					max = Math.max(max, j - i);
					break;
				}
				if (j == s.length() - 1) {
					max = Math.max(max, j - i + 1);
					break;
				}
				hs.add(s.charAt(j));
			}
		}
		return max;
	}

	// 最佳解法
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLen = 0;
		for (int i = 0, subStringStart = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				subStringStart = Math.max(subStringStart, map.get(c) + 1);
			}
			map.put(c, i);
			maxLen = Math.max(maxLen, i - subStringStart + 1);
		}
		return maxLen;
	}
}
