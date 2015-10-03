package shcell.Algorithm;

import java.util.Arrays;
import java.util.HashSet;
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

	public static void main(String[] args) {
		// HashSet<person> hs = new HashSet<>();
		// person p1 = new person("w", 20);
		//
		// hs.add(p1);
		// hs.add(new person("d", 22));
		// System.out.println(hs.add(new person("w", 20)));
		// System.out.println(Arrays.deepToString(hs.toArray()));
		System.out.println(letterCombinations("232").size());

	}

	// 暴力解法
	public static List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.length() == 0)
			return ans;
		String[] mapping = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
				"wxyz" };
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

}

class person {
	public String name;
	public int age;

	public person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "*person: " + name + " " + age;

	}

	@Override
	public boolean equals(Object o) {
		return false;

	}

	@Override
	public int hashCode() {
		return age;
	}

}
