package shcell.Algorithm;

public class T79WordSearch {

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		System.out.println(new T79WordSearch().exist(board, word));
	}

	char[][] board;
	char[] target;

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		this.board = board;
		this.target = word.toCharArray();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(i, j, 0))
					return true;
			}
		}
		return false;
	}

	private boolean dfs(int i, int j, int index) {
		if (index == target.length)
			return true;
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
				|| target[index] != board[i][j])
			return false;
		board[i][j] = '*';
		if (dfs(i + 1, j, index + 1) || dfs(i - 1, j, index + 1) || dfs(i, j + 1, index + 1)
				|| dfs(i, j - 1, index + 1))
			return true;
		board[i][j] = target[index];
		return false;
	}

}
