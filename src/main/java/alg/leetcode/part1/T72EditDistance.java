package alg.leetcode.part1;

public class T72EditDistance {

	public static void main(String[] args) {
		String word1 = "a";
		String word2 = "ab";
		System.out.println(minDistance(word1, word2));
	}

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] distance = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (i == 0) {
					distance[i][j] = j;
				} else if (j == 0) {
					distance[i][j] = i;
				} else if (word1.charAt(i - 1) == word2.charAt(j - 1))
					distance[i][j] = distance[i - 1][j - 1];
				else {
					distance[i][j] = Math.min(distance[i - 1][j - 1],
							Math.min(distance[i - 1][j], distance[i][j - 1])) + 1;
				}
			}
		}
		return distance[len1][len2];
	}
}
