package alg.leetcode.part1;

public class T37SudokuSolver {

	public static void main(String[] args) {
		// System.out.println(removeNthFromEnd2(1));
	}

	// 暴力解法
	public static void solveSudoku(char[][] board) {
		testNumber(board, 0);
	}

	private static boolean testNumber(char[][] board, int row) {
		for (int i = row; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != '.')
					continue;
				else {
					for (int j2 = 0; j2 < board.length; j2++) {
						board[i][j] = (char) ('1' + j2);
						if (!isValidSudoku(board))
							continue;
						if (testNumber(board, i))
							return true;
					}
					board[i][j] = '.';
					return false;
				}
			}
		}
		return true;
	}

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
