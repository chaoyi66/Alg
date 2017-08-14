package alg.leetcode.part1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

*/
public class T20ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("]"));
	}

	// 主要是注意边界条件，在检测过程中栈不能为空，遍历完成后栈必须为空
	public static boolean isValid(String s) {
		HashMap<Character, Character> pairs = new HashMap<>();
		HashSet<Character> right = new HashSet<>();
		pairs.put('(', ')');
		pairs.put('[', ']');
		pairs.put('{', '}');
		right.add(')');
		right.add(']');
		right.add('}');
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (pairs.containsKey(c))
				stack.push(c);
			else if (right.contains(c)
					&& (stack.isEmpty() || (!(c.equals(pairs.get(stack.pop())))))) {
				return false;
			}
		}
		return stack.isEmpty();

	}

}
