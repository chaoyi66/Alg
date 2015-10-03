package shcell.Algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Given an array S of n integers, find three integers in S such that
 *  the sum is closest to a given number, target. Return the sum of 
 *  the three integers. You may assume that each input would have 
 *  exactly one solution.
 *  
 *  For example, given array S = {-1 2 1 -4}, and target = 1.
 *  The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class T16ThreeSumClosest {

	// public static void main(String[] args) {
	//
	// }

	// 暴力解法
	public static int threeSumClosest(int[] nums, int target) {
		int len = nums.length;
		int sum = nums[0] + nums[1] + nums[len - 1];
		Arrays.sort(nums);
		for (int i = 0; i < len - 2; i++) {
			int j = i + 1, k = len - 1, diff;
			while (j < k) {
				diff = nums[i] + nums[j] + nums[k] - target;
				if (diff > 0)
					k--;
				else if (diff < 0)
					j++;
				else
					return target;
				if (Math.abs(sum - target) > Math.abs(diff))
					sum = diff + target;
			}
		}
		return sum;
	}

}
