package alg.leetcode.part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T30SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = new String[] { "foo", "bar" };
		System.out.println(findSubstring(s, words));
	}

	public static List<Integer> findSubstring(String S, String[] L) {
		List<Integer> ans = new ArrayList<Integer>();
		if (S.length() < 1 || L.length < 1)
			return ans;
		int len = L[0].length(); // 题目说L中每个单词长度一样

		// 初始化HashMap，注意L中可能包含多个相同的字符串，所以用value表示个数
		HashMap<String, Integer> oMap = new HashMap<String, Integer>();
		for (int j = 0; j < L.length; j++) {
			oMap.put(L[j], oMap.getOrDefault(L[j], 0) + 1);
		}
		// i的范围很关键，如果直接到S.length()是会超时的
		for (int i = 0; i <= S.length() - L.length * len; i++) {
			int from = i;
			String str = S.substring(from, from + len);
			if (!oMap.containsKey(str))
				continue;
			@SuppressWarnings("unchecked")
			HashMap<String, Integer> map = (HashMap<String, Integer>) (oMap.clone());
			int cnt = 0;
			while (map.containsKey(str) && map.get(str) > 0) {
				map.put(str, map.get(str) - 1);
				cnt++;
				from += len;
				if (from + len > S.length())
					break; // 注意越界
				str = S.substring(from, from + len);
			}

			// L中每个单词恰好出现一次，加入到结果集
			if (cnt == L.length) {
				ans.add(i);
			}
		}
		return ans;
	}
}
