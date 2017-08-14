package alg.leetcode.part1;

import java.util.ArrayList;
import java.util.List;

public class T68TextJustification {

	public static void main(String[] args) {
		String[] words = new String[] { "a", " b ", "c", "d" };
		int L = 1;
		// String[] words = new String[] { "This", "is", "an", "example", "of",
		// "text",
		// "justification." };
		// int L = 16;
		System.out.println(fullJustify(words, L));
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> lines = new ArrayList<>();
		int len = 0;
		int index = 0;
		int wordsQty = words.length;
		while (index < wordsQty) {
			List<String> thisLine = new ArrayList<>();
			len = 0;
			while (index < wordsQty) {
				String word = words[index];
				int charsCount = word.trim().length();
				if (charsCount == 0) {
					index++;
					continue;
				} else if (len + charsCount + (thisLine.isEmpty() ? 0 : 1) > maxWidth)
					break;
				else {
					len += charsCount + (thisLine.isEmpty() ? 0 : 1);
					thisLine.add(word.trim());
					index++;
				}
			}

			int count = thisLine.size();
			String head = count > 0 ? thisLine.get(0) : "";
			StringBuilder sb = new StringBuilder(head);
			if (index == wordsQty) {
				// 最末尾一行，特别对待，不需要平均填空
				for (int i = 1; i < thisLine.size(); i++)
					sb.append(" ").append(thisLine.get(i));
				sb.append(getNSpace(maxWidth - len));
			} else {
				int space = maxWidth - (len + 1 - count);
				if (count == 1) {
					lines.add(sb.append(getNSpace(space)).toString());
					continue;
				} else {
					int[] spaceCount = div(space, count - 1);
					for (int i = 1; i < count; i++)
						sb.append(getNSpace(spaceCount[i - 1])).append(thisLine.get(i));
				}
			}
			lines.add(sb.toString());
		}
		return lines;
	}

	private static String getNSpace(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(" ");
		return sb.toString();
	}

	private static int[] div(int total, int qty) {
		int avg = total / qty;
		int[] nums = new int[qty];
		for (int i = 0; i < qty; i++)
			nums[i] = avg + (i < total % qty ? 1 : 0);
		return nums;
	}

	// discuss中比较简洁的解法,用一个padding来节省反复拼接空格的操作
	public List<String> fullJustify1(String[] words, int L) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < L; ++i)
			sb.append(" ");
		final String pads = sb.toString();
		final List<String> strs = new ArrayList<>();
		for (int i = 0, sum = 0, j = 0; i < words.length; i = j) {
			for (j = i + 1, sum = words[i].length(); j < words.length
					&& sum + j - i + words[j].length() <= L; ++j)
				sum += words[j].length();

			final StringBuilder builder = new StringBuilder();
			final int n = j - 1 - i;
			final int m = (j == words.length || 0 == n) ? 1 : ((L - sum) / n);
			final int b = (j == words.length) ? 0 : (L - sum - m * n);

			for (int k = i; k < j - 1; ++k)
				builder.append(words[k]).append(pads.substring(0, (k - i < b) ? (m + 1) : m));

			builder.append(words[j - 1]);
			if (j == words.length || 0 == n)
				builder.append(pads.substring(0, L - sum - n));

			strs.add(builder.toString());
		}

		return strs;
	}
}
