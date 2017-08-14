package leetcode.part1;

import java.util.Arrays;
import java.util.Stack;

public class T32LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()"));
	}

	public static int longestValidParentheses(String s) {
		int len = s.length();
		boolean[] pair = new boolean[len];
		Arrays.fill(pair, false);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else if (s.charAt(i) == ')' && !stack.isEmpty()) {
				pair[i] = true;
				pair[stack.pop()] = true;
			}
		}
		int ans = 0;
		int count = 0;
		for (int i = 0; i < pair.length; i++) {
			if (pair[i]) {
				count++;
				ans = Math.max(ans, count);
			} else
				count = 0;
		}
		return ans;
	}

	public int longestValidParentheses1(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int left = -1;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '(')
				stack.push(j);
			else {
				if (stack.isEmpty())
					left = j;
				else {
					stack.pop();
					if (stack.isEmpty())
						max = Math.max(max, j - left);
					else
						max = Math.max(max, j - stack.peek());
				}
			}
		}
		return max;
	}
}
