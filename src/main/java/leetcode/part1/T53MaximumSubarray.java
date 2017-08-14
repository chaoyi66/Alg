package leetcode.part1;

import java.util.Arrays;

public class T53MaximumSubarray {

	public static void main(String[] args) {
		Integer[] nums = new Integer[] { 1, 2, -2, 1, 3, 2, -3, -5, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(Integer[] nums) {
		int sum = 0, smax = Integer.MIN_VALUE;
		for (int num : nums) {
			sum += num;
			if (sum > smax)
				smax = sum;
			if (sum < 0)
				sum = 0;
		}
		return smax;
	}

	public static int maxSubArray1(Integer[] nums) {
		int sum = nums[0];
		int i = 0, count = 0;
		for (i = 1; i < nums.length; i++) {
			if (nums[i] * sum >= 0)
				sum += nums[i];
			else {
				nums[count++] = sum;
				sum = nums[i];
			}
		}
		nums[count++] = sum;
		Integer[] res = Arrays.copyOfRange(nums, 0, count);

		i = 0;
		count = 0;
		while (count > 2 && i + 2 < res.length) {
			if (res[i + 1] < 0 && res[i] > Math.abs(res[i + 1])
					&& res[i + 2] > Math.abs(res[i + 1])) {
				res[count++] = res[i] + res[i + 1] + res[i + 2];
				i += 3;
			} else {
				res[count++] = res[i];
				i++;
			}
		}
		Arrays.sort(res);
		// return res[res.length-1];
		System.out.println(Arrays.deepToString(res));
		return 0;
	}

}
