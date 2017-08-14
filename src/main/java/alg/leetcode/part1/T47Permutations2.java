package alg.leetcode.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class T47Permutations2 {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 0, 0, 1, -1, -1, 1 };
		System.out.println(new T47Permutations2().permuteUnique(nums));
		// list的equals方法已经复写，当list中的元素完全相同时才会判定想等
		// List<Integer> l1 = new ArrayList<>();
		// List<Integer> l2 = new ArrayList<>();
		// l1.add(1);
		// l2.add(1);
		// System.out.println(l1 == l2);
		// System.out.println(l1.equals(l2));
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		permute(ans, nums, 0);
		return ans;
	}

	private void permute(List<List<Integer>> ans, int[] nums, int index) {
		if (index == nums.length) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int x : nums)
				list.add(x);
			ans.add(new ArrayList<>(list));
			return;
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = index; i < nums.length; i++) {
			if (set.contains(nums[i]))
				continue;
			set.add(nums[i]);
			swap(nums, index, i);
			permute(ans, nums, index + 1);
			swap(nums, index, i);
		}
	}

	public void swap(int[] nums, int i, int j) {
		if (i == j)
			return;
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}

}
