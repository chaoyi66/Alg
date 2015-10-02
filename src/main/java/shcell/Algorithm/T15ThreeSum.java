package shcell.Algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the array 
 * which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class T15ThreeSum {

	// public static void main(String[] args) {
	//
	// }

	// 暴力解法
	public List<List<Integer>> threeSum1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (nums[j] == nums[j - 1])
					continue;
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[k] == nums[k - 1])
						continue;
					if (i + j + k == 0) {
						List<Integer> tmpList = Arrays.asList(nums[i], nums[j], nums[k]);
						list.add(tmpList);
					}

				}
			}
		}
		return list;
	}

	// O(n^2)算法
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> tmpList = Arrays.asList(nums[i], nums[j], nums[k]);
					list.add(tmpList);
					while (j < k && nums[j] == nums[j + 1])
						j++;
					while (j < k && nums[k] == nums[k - 1])
						k--;
					j++;
					k--;
				} else if (sum > 0) {
					while (j < k && nums[k] == nums[k - 1])
						k--;
					k--;
				} else {
					while (j < k && nums[j] == nums[j + 1])
						j++;
					j++;
				}
			}
		}
		return list;
	}
}
