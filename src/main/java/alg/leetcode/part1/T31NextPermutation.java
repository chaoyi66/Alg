package alg.leetcode.part1;

import java.util.Arrays;

import alg.commons.MyArrayUtils;

public class T31NextPermutation {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 0 };
		Arrays.sort(nums, 1, 5);
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));

	}

	public static void nextPermutation(int[] nums) {
		int len = nums.length;
		if (len <= 1)
			return;
		int p = len - 2;
		while (p >= 0 && nums[p + 1] <= nums[p])
			p--;
		if (p >= 0) {
			int i = len - 1;
			while (nums[p] >= nums[i])
				i--;
			MyArrayUtils.swap(nums, p, i);
		}
		reverse(nums, p + 1, len - 1);
	}

	public static void reverse(int[] nums, int begin, int end) {
		while (begin < end) {
			MyArrayUtils.swap(nums, begin, end);
			begin++;
			end--;
		}
	}
}
