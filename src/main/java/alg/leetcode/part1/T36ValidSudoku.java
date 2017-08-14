package alg.leetcode.part1;

public class T36ValidSudoku {

	public static void main(String[] args) {
		String[] s = new String[] { ".........", "4........", "......6..", "...38....", ".5...6..1",
				"8......6.", ".........", "..7.9....", "...6....." };
		char[][] board = new char[s.length][];
		for (int i = 0; i < s.length; i++) {
			board[i] = s[i].toCharArray();
		}
		System.out.println(isValidSudoku(board));
	}

	// 暴力解法
	public static boolean isValidSudoku(char[][] board) {
		int len = board.length;
		boolean[][] colValid = new boolean[len][len], rowValid = new boolean[len][len],
				squreValid = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (board[i][j] == '.')
					continue;
				int c = board[i][j] - '1';
				if (rowValid[i][c] || colValid[j][c] || squreValid[i / 3 * 3 + j / 3][c])
					return false;
				rowValid[i][c] = true;
				colValid[j][c] = true;
				squreValid[i / 3 * 3 + j / 3][c] = true;
			}
		}
		return true;
	}
}
