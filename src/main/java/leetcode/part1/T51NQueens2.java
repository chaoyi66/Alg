package leetcode.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T51NQueens2 {

	public static void main(String[] args) {
		System.out.println(new T51NQueens2().solveNQueens(4));

	}

	int n;
	int[] positions;
	List<int[]> solus = new ArrayList<>();
	List<List<String>> solusStr = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		this.n = n;
		positions = new int[n];

		for (int i = 0; i < n; i++) {
			solve(i + 1, 1);
		}
		for (int[] solu : solus) {
			solusStr.add(grStr(solu));
		}
		// System.out.println(solusStr);
		 System.out.println(solusStr.size());
		return solusStr;
	}

	public void solve(int row, int col) {
		if (!check(row, col))
			return;
		positions[row - 1] = col;
		if (col == n) {
			solus.add(Arrays.copyOf(positions, n));
			positions[row - 1] = 0;
			return;
		}
		for (int newRow = 1; newRow <= n; newRow++) {
			solve(newRow, col + 1);
		}
		positions[row - 1] = 0;
	}

	private boolean check(int row, int col) {
		for (int i = 0; i < n; i++) {
			if (positions[i] != 0) {
				int oldRow = i + 1;
				int oldCol = positions[i];
				if (row == oldRow || col == oldCol
						|| Math.abs(row - oldRow) == Math.abs(col - oldCol)) {
					return false;
				}
			}
		}
		return true;
	}

	private List<String> grStr(int[] solu) {
		char[] cs = new char[n];
		Arrays.fill(cs, '.');
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			int col = solu[i];
			cs[col - 1] = 'Q';
			list.add('\n' + new String(cs));
			cs[col - 1] = '.';
		}
		return list;
	}

}
