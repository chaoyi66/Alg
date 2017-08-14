package leetcode.part2;

import java.util.Arrays;

public class T242ValidAnagram {

	public static void main(String[] args) {
		System.out.println();
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		Arrays.sort(sc);
		Arrays.sort(tc);
		int i = 0;
		for (i = 0; i < s.length(); i++) {
			if (sc[i] != tc[i])
				break;
		}
		if (i == s.length())
			return true;
		return false;
	}

	public boolean isAnagram1(String s, String t) {
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++)
			alphabet[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++)
			alphabet[t.charAt(i) - 'a']--;
		for (int i : alphabet)
			if (i != 0)
				return false;
		return true;
	}

}
