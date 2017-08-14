package alg.leetcode.part1;

import java.util.LinkedList;
import java.util.TreeMap;

public class T76MinimumWindowSubstring {

	public static void main(String[] args) {
		String s = "aa";
		String t = "aa";
		System.out.println(minWindow(s, t));
	}

//	尚未解决，碰到t中有重复字母的还不行
	public static String minWindow(String s, String t) {
		TreeMap<Integer, Character> map = new TreeMap<>();
		LinkedList<Character> list=new LinkedList<>();
		for (Character c : t.toCharArray())
			list.add(c);
		int index = 0;
		while (map.size() < t.length() && index < s.length()) {
			Character c = s.charAt(index);
			if (list.contains(c)) {
				list.remove(c);
				map.put(index, c);
			}else {
				
			}
			
			index++;
		}
		if (index == s.length() && map.size() != t.length())
			return "";
		int start = map.firstKey(), end = map.lastKey() + 1;
		int min = end - start;
		while (index < s.length()) {
			Character c = s.charAt(index);
			if (map.values().contains(c) && map.get(start).equals(c)) {
				int tmp = map.higherKey(start);
				if (min > index - tmp + 1) {
					start = tmp;
					end = index + 1;
					min = end - start;
				}
			}
			map.put(index, c);
			index++;
		}
		return s.substring(start, end);
	}

}
