package alg.leetcode.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* Given a digit string, return all possible letter combinations that 
 * the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * */

public class T22GenerateParentheses {

	public static void main(String[] args) {
		int n=12;
		long t1=System.currentTimeMillis();
		generateParenthesis1(n);
		long t2=System.currentTimeMillis();
		System.out.println("function1 cost: "+(t2-t1));
		
		generateParenthesis2(n);
		long t3=System.currentTimeMillis();
		System.out.println("function2 cost: "+(t3-t2));
		
		generateParenthesis3(n);
		long t4=System.currentTimeMillis();
		System.out.println("function3 cost: "+(t4-t3));
		
		generateParenthesis4(n);
		long t5=System.currentTimeMillis();
		System.out.println("function4 cost: "+(t5-t4));

		
		
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	// 暴力解法
	public static List<String> generateParenthesis1(int n) {
		HashMap<String, Pair> map = new HashMap<>();

		map.put("", new Pair(0, 0));
		for (int i = 0; i < 2 * n; i++) {
			HashMap<String, Pair> tmpMap = new HashMap<>();
			for (String sb : map.keySet()) {
				Pair pair = map.get(sb);
				if (pair.x == pair.y) {
					tmpMap.put(sb + "(", new Pair(pair.x + 1, pair.y));
				} else if (pair.x < n) {
					tmpMap.put(sb + "(", new Pair(pair.x + 1, pair.y));
					tmpMap.put(sb + ")", new Pair(pair.x, pair.y + 1));
				} else {
					tmpMap.put(sb + ")", new Pair(pair.x + 1, pair.y));
				}
			}
			map = tmpMap;
		}
		return Arrays.asList(map.keySet().toArray(new String[map.size()]));
	}

	// 排列组合的方法
	public static List<String> generateParenthesis2(int n) {
		HashSet<String> result = new HashSet<>();
		result.add("#");
		for (int i = 0; i < n; i++) {
			HashSet<String> tmpSet = new HashSet<>();
			for (String s : result) {
				for (int j = 0; j < s.length(); j++) {
					String newS = s.substring(0, j + 1) + "()" + s.substring(j + 1, s.length());
					tmpSet.add(newS);
				}
			}
			result = tmpSet;
		}
		HashSet<String> tmp = new HashSet<>();
		for (String s : result) {
			tmp.add(s.substring(1, s.length()));
		}
		return Arrays.asList(tmp.toArray(new String[result.size()]));
	}

	// 递归版本
	public static List<String> generateParenthesis3(int n) {
		List<String> list = new ArrayList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	public static void backtrack(List<String> list, String str, int open, int close, int max) {

		if (str.length() == max * 2) {
			list.add(str);
			return;
		}

		if (open < max)
			backtrack(list, str + "(", open + 1, close, max);
		if (close < open)
			backtrack(list, str + ")", open, close + 1, max);
	}

	// 深度优先搜索
	public static List<String> generateParenthesis4(int n) {
		List<String> list = new ArrayList<String>();
		generateOneByOne("", list, n, n);
		return list;
	}

	public static void generateOneByOne(String sublist, List<String> list, int left, int right) {
		if (left > right) {
			return;
		}
		if (left > 0) {
			generateOneByOne(sublist + "(", list, left - 1, right);
		}
		if (right > 0) {
			generateOneByOne(sublist + ")", list, left, right - 1);
		}
		if (left == 0 && right == 0) {
			list.add(sublist);
			return;
		}
	}
}
