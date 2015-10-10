package shcell.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T40CombinationSum2 {

	public static void main(String[] args) {
		int[] candidates = new int[] { 1, 2, 2, 2, 2, 2, 2 };
		int target = 7;
		System.out.println(new T40CombinationSum2().combinationSum2(candidates, target));
	}

	List<List<Integer>> result = new ArrayList<List<Integer>>();
	ArrayList<Integer> path = new ArrayList<>();
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
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (i > index && candidates[i - 1] == candidates[i]) // 第一个数值的子节点已经解决这种情况，所以不需要重复
				continue;
			int sumCopy = sum + candidates[i];
			path.add(candidates[i]);
			dfs(sumCopy, i + 1);
			path.remove(path.size() - 1);
		}
	}

}
