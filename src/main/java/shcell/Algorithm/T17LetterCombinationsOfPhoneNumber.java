package shcell.Algorithm;

import java.util.LinkedList;
import java.util.List;

/* Given a digit string, return all possible letter combinations that 
 * the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be 
in any order you want.
*/

public class T17LetterCombinationsOfPhoneNumber {
	static String[] mapping = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
			"tuv", "wxyz" };

	public static void main(String[] args) {
		System.out.println(letterCombinations1("232"));

	}

	// FIFO队列的精妙解法
	public static List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.length() == 0)
			return ans;
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;

	}

	// 暴力解法
	public static List<String> letterCombinations1(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.length() == 0)
			return ans;
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			LinkedList<String> tmp = new LinkedList<>();
			for (String s : ans) {
				for (char c : mapping[x].toCharArray()) {
					tmp.add(s + c);
				}
			}
			ans = tmp;
		}
		return ans;

	}

}
