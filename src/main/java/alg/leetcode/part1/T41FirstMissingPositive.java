package alg.leetcode.part1;

import alg.commons.MyArrayUtils;

public class T41FirstMissingPositive {

	public static void main(String[] args) {
		int[] candidates = new int[] { 1, 1 };
		System.out.println(firstMissingPositive(candidates));
	}

	public static int firstMissingPositive(int[] nums) {
		int N = nums.length;
		for (int i = 0; i < N; i++) {
			while (nums[i] > 0 && nums[i] <= N && nums[nums[i] - 1] != nums[i])
				// 为什么第三个条件不能用 nums[i]!=i+1 , 还没想明白！！！！
				MyArrayUtils.swap(nums, i, nums[i] - 1);
		}
		int i = 0;
		while (i < N && nums[i] == i + 1) {
			i++;
		}
		return i + 1;
	}
}
