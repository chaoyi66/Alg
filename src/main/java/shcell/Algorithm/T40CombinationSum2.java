package shcell.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T40CombinationSum2 {

	public static void main(String[] args) {
		int[] candidates = new int[] { 1 };
		int target = 1;
		System.out.println(new T40CombinationSum2().combinationSum2(candidates, target));
	}

	List<List<Integer>> result = new ArrayList<List<Integer>>();
	ArrayList<Integer> solu = new ArrayList<>();
	int[] candidates;
	int targe;

	// 深度优先搜索加剪枝(修改版)
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		this.candidates = candidates;
		this.targe = target;
		Arrays.sort(candidates);
		dfs(0, 0);
		return result;

	}

	public void dfs(int sum, int index) {
		if (sum > targe)
			return;
		if (sum == targe) {
			if (!result.contains(solu))
				result.add(new ArrayList<>(solu));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			int sumCopy = sum + candidates[i];
			solu.add(candidates[i]);
			dfs(sumCopy, i + 1);
			solu.remove(solu.size() - 1);
		}
	}

}
