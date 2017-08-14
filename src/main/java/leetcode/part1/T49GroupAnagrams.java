package leetcode.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class T49GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = new String[] { "tea", "and", "ate", "eat", "den" };
		List<String> ls = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			char[] c = new char[] { ((char) ((int) 'a' + i)) };
			ls.add(new String(c));
		}
		List<String> ls2 = new ArrayList<>(ls);
		ls2.add(" ");
		ls2.remove("a");
		List<List<String>> ans = new ArrayList<>();
		ls.add(" ");
		ans.add(ls);
		ans.add(ls2);
		Collections.sort(ans, (x, y) -> {
			Iterator<String> itx = x.iterator();
			Iterator<String> ity = y.iterator();

			while (itx.hasNext() && ity.hasNext()) {
				String xStr = itx.next();
				String yStr = ity.next();
				if (!xStr.equals(yStr))
					return xStr.compareTo(yStr);
			}
			return x.size() - y.size();

		});
		System.out.println(groupAnagrams(strs));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Arrays.sort(strs);
		List<List<String>> ans = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			if (map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				map.put(key, list);
			}
		}
		for (List<String> vList : map.values()) {
			ans.add(vList);
		}		
		return ans;
	}

}
