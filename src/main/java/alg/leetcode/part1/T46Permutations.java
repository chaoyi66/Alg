package alg.leetcode.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T46Permutations {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4 };
		System.out.println(new T46Permutations().permute(nums));
		// list的equals方法已经复写，当list中的元素完全相同时才会判定想等
		// List<Integer> l1 = new ArrayList<>();
		// List<Integer> l2 = new ArrayList<>();
		// l1.add(1);
		// l2.add(1);
		// System.out.println(l1 == l2);
		// System.out.println(l1.equals(l2));
	}

	// 回溯法
	public List<List<Integer>> permute1(int[] nums) {
		Arrays.sort(nums);
		boolean[] out = new boolean[nums.length];
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> lists = new ArrayList<>();
		dfs(lists, list, nums, out);
		return lists;
	}

	private void dfs(List<List<Integer>> lists, List<Integer> list, int[] nums, boolean[] out) {
		int n = list.size();
		if (n == nums.length) {
			if (!lists.contains(list))
				lists.add(list);
			return;
		}
		for (int i = 0; i < out.length; i++) {
			if (!out[i]) {
				list.add(nums[i]);
				List<Integer> listCopy = new ArrayList<>(list);
				out[i] = true;
				dfs(lists, listCopy, nums, out);
				out[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}

	// 基于交换的方案，不需要额外的空间
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permute(result, num, 0);
		return result;
	}

	private void permute(List<List<Integer>> result, int[] array, int start) {
		if (start >= array.length) {
			List<Integer> current = new ArrayList<Integer>();
			for (int a : array) {
				current.add(a);
			}
			result.add(current);
		} else {
			for (int i = start; i < array.length; i++) {
				swap(array, start, i);
				permute(result, array, start + 1);
				swap(array, start, i);
			}
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// 基于位置插入的方案

	/*
	 * the basic idea is, to permute n numbers, we can add the nth number into
	 * the resulting List<List<Integer>> from the n-1 numbers, in every possible
	 * position.
	 * 
	 * For example, if the input num[] is {1,2,3}: First, add 1 into the initial
	 * List<List<Integer>> (let's call it "answer").
	 * 
	 * Then, 2 can be added in front or after 1. So we have to copy the List in
	 * answer (it's just {1}), add 2 in position 0 of {1}, then copy the
	 * original {1} again, and add 2 in position 1. Now we have an answer of
	 * {{2,1},{1,2}}. There are 2 lists in the current answer.
	 * 
	 * Then we have to add 3. first copy {2,1} and {1,2}, add 3 in position 0;
	 * then copy {2,1} and {1,2}, and add 3 into position 1, then do the same
	 * thing for position 3. Finally we have 2*3=6 lists in answer, which is
	 * what we want.
	 */
	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (nums.length == 0)
			return ans;
		ans.add(new ArrayList<Integer>());
		for (int i = 0; i < nums.length; ++i) {
			List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
			for (int j = 0; j <= i; ++j) {
				for (List<Integer> l : ans) {
					List<Integer> new_l = new ArrayList<Integer>(l);
					new_l.add(j, nums[i]);
					new_ans.add(new_l);
				}
			}
			ans = new_ans;
		}
		return ans;
	}

}
