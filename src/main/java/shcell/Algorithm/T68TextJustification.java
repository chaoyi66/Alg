package shcell.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class T68TextJustification {

	public static void main(String[] args) {
		String[] words = new String[] { "" };
		int L = 2;
//		String[] words = new String[] { "This", "is", "an", "example", "of", "text",
//		"justification." };
//		int L = 16;
		System.out.println(fullJustify(words, L));
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> ans = new ArrayList<>();
		int len = 0;
		int index = 0;
		int wordsQty = words.length;
		while (index < wordsQty) {
			List<String> thisLine = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			len = 0;
			while (index < wordsQty
					&& len + words[index].length() + (thisLine.isEmpty() ? 0 : 1) <= maxWidth) {
				String word = words[index];
				len += word.length()+ (thisLine.isEmpty() ? 0 : 1);
				thisLine.add(word);
				index++;
			}
			if (index == wordsQty) {
				sb.append(thisLine.get(0));
				for (int i = 1; i < thisLine.size(); i++) {
					sb.append(" ").append(thisLine.get(i));
				}
				sb.append(getNSpace(maxWidth-len));
			} else {
				int count = thisLine.size();
				int space = maxWidth - (len+1-count);
				if (count == 1) {
					String str = getNSpace(space / 2 + space % 2) + thisLine.get(0)
							+ getNSpace(space / 2);
					ans.add(str);
				} else {
					int[] spaceCount = div(space, count - 1);
					sb.append(thisLine.get(0));
					for (int i = 1; i < count; i++) {
						sb.append(getNSpace(spaceCount[i - 1])).append(thisLine.get(i));
					}
				}
			}
			ans.add(sb.toString());
		}
		return ans;
	}

	private static String getNSpace(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	private static int[] div(int total, int qty) {
		int avg = total / qty;
		int[] nums = new int[qty];
		for (int i = 0; i < qty; i++)
			nums[i] = avg + (i < total % qty ? 1 : 0);
		return nums;
	}

}
