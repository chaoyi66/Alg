package leetcode.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T77Combinations {

	public static void main(String[] args) {
		System.out.println(new T77Combinations().combine(4, 2));
	}

	public List<List<Integer>> combine1(int n, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		dfs(n, ans, new ArrayList<>(), 0, k);
		return ans;
	}

	private void dfs(int n, List<List<Integer>> ans, List<Integer> list, int index, int k) {
		if (k == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}
		if (index >= n)
			return;
		dfs(n, ans, list, index + 1, k);
		list.add(index + 1);
		dfs(n, ans, list, index + 1, k - 1);
		list.remove(list.size() - 1);
	}

//	Basically, this solution follows the idea of 
//	the mathematical formula C(n,k)=C(n-1,k-1)+C(n-1,k).
	public List<List<Integer>> combine(int n, int k) {
		if (k == n || k == 0) {
			List<Integer> row = new LinkedList<>();
			for (int i = 1; i <= k; ++i) {
				row.add(i);
			}
			return new LinkedList<>(Arrays.asList(row));
		}
		List<List<Integer>> result = this.combine(n - 1, k - 1);
		result.forEach(e -> e.add(n));
		result.addAll(this.combine(n - 1, k));
		return result;
	}
}
