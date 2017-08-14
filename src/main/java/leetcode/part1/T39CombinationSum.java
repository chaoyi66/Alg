package leetcode.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T39CombinationSum {

	public static void main(String[] args) {
		int[] candidates = new int[] { 2, 3, 6, 7 };
		int target = 7;
		System.out.println(combinationSum2(candidates, target));
	}

	static List<List<Integer>> result = new ArrayList<List<Integer>>();
	static int[] candidates;
	static int targe;

	// 深度优先搜索加剪枝(修改版)
	public static List<List<Integer>> combinationSum2(int[] candidates1, int target1) {
		candidates = candidates1;
		targe = target1;
		Arrays.sort(candidates);
		dfs(new ArrayList<Integer>(), 0, 0);
		return result;

	}

	public static void dfs(List<Integer> solu, int sum, int index) {
		for (int j = index; j < candidates.length; j++) {
			sum += candidates[j];
			ArrayList<Integer> soluCopy = new ArrayList<>(solu);
			soluCopy.add(candidates[j]);
			if (sum > targe) 
				break;			
			if (sum == targe) {
				result.add(new ArrayList<>(soluCopy));
				return;
			}
			dfs(soluCopy, sum, j);
			sum -= candidates[j];
		}
	}
	
//	// 深度优先搜索加剪枝(原始版)	
//	static List<List<Integer>> result = new ArrayList<List<Integer>>();
//	static List<Integer> solu = new ArrayList<Integer>();
//

//	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//		Arrays.sort(candidates);
//		dfs(candidates, target, 0, 0);
//		return result;
//
//	}
//
//	public static void dfs(int[] candidates, int target, int sum, int i) {
//		if (sum > target)
//			return;
//		if (sum == target) {
//			result.add(new ArrayList<>(solu));
//			return;
//		}
//		for (int j = i; j < candidates.length; j++) {
//			sum += candidates[j];
//			solu.add(candidates[j]);
//			dfs(candidates, target, sum, j);
//			solu.remove(solu.size() - 1);
//			sum -= candidates[j];
//		}
//	}

	// 我自己的版本，比较笨,类似于DP的方法，感觉dp比较适合只返回数量的情况下
	public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
		Arrays.sort(candidates);
		return cmbSum(candidates, target, new HashMap<Integer, List<List<Integer>>>());
	}

	public static List<List<Integer>> cmbSum(int[] candidates, int target,
			HashMap<Integer, List<List<Integer>>> map) {
		List<List<Integer>> listList = new ArrayList<List<Integer>>();
		int t = Arrays.binarySearch(candidates, target);
		if (t >= 0) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			a.add(candidates[t]);
			listList.add(a);
		}
		for (int i = 1; i <= target / 2; i++) {
			List<List<Integer>> l1 = map.containsKey(i) ? map.get(i) : cmbSum(candidates, i, map);
			List<List<Integer>> l2 = map.containsKey(target - i) ? map.get(target - i)
					: cmbSum(candidates, target - i, map);
			if (l1.size() != 0 && l2.size() != 0) {
				for (int j = 0; j < l1.size(); j++) {
					for (int k = 0; k < l2.size(); k++) {
						List<Integer> a1 = new ArrayList<>(l1.get(j));
						List<Integer> a2 = l2.get(k);
						a1.addAll(a2);
						Collections.sort(a1);
						if (!listList.contains(a1)) {
							listList.add(a1);
						}
					}
				}
			}

		}
		map.put(target, listList);
		return listList;
	}

	// 最佳版本
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		Arrays.sort(candidates); // sort the candidates
		// collect possible candidates from small to large to eliminate
		// duplicates,
		recurse(ans, new ArrayList<Integer>(), target, candidates, 0);
		return ans;
	}

	// the index here means we are allowed to choose candidates from that index
	private static void recurse(List<List<Integer>> ans, List<Integer> list, int target,
			int[] candidates, int index) {
		if (target == 0) {
			ans.add(list);
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			int newTarget = target - candidates[i];
			if (newTarget >= 0) {
				List<Integer> copy = new ArrayList<Integer>(list);
				copy.add(candidates[i]);
				recurse(ans, copy, newTarget, candidates, i);
			} else {
				break;
			}
		}
	}

}
