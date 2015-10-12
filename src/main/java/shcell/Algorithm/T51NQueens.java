package shcell.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class T51NQueens {

	public static void main(String[] args) {
		new T51NQueens().solveNQueens(11);
	}

	int n;
	Map<Integer, Integer> positions = new HashMap<>();
	List<Map<Integer, Integer>> solus = new ArrayList<>();
	List<List<String>> solusStr = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		this.n = n;
		Set<Integer> rows = new HashSet<>();
		for (int i = 0; i < n; i++) {
			rows.add(i + 1);
		}
		for (int i = 0; i < n; i++) {
			solve(i + 1, 1, rows);
		}
		for (Map<Integer, Integer> solu : solus) {
			solusStr.add(grStr(solu));
		}
		System.out.println(solusStr);
		System.out.println(solusStr.size());

		return null;
	}

	public void solve(int row, int col, Set<Integer> rows) {
		if (!check(row, col))
			return;
		positions.put(row, col);
		rows.remove(row);
		if (rows.isEmpty()) {
			solus.add(new HashMap<Integer, Integer>(positions));
			positions.remove(row);
			rows.add(row);
			return;
		}
		for (int newRow : rows) {
			if (Math.abs(row - newRow) <= 1)
				continue;
			solve(newRow, col + 1, new HashSet<>(rows));
		}
		positions.remove(row);
		rows.add(row);
	}

	private boolean check(int row, int col) {
		for (Entry<Integer, Integer> position : positions.entrySet()) {
			int oldRow = position.getKey();
			int oldCol = position.getValue();
			if ( Math.abs(row - oldRow) == Math.abs(col - oldCol)) {
				return false;
			}
		}
		return true;
	}

	private List<String> grStr(Map<Integer, Integer> solu) {
		char[] cs = new char[n];
		Arrays.fill(cs, '.');
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			int col = solu.get(i + 1);
			cs[col - 1] = 'Q';
			list.add('\n' + new String(cs));
			cs[col - 1] = '.';
		}
		return list;
	}

}
