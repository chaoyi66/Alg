package leetcode.part2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class T217ContainsDuplicate {

	public static void main(String[] args) {
		System.out.println();
	}

	public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				return true;
			} else {
				map.put(num, 0);
			}
		}
		return false;

	}

	public boolean containsDuplicate1(int[] nums) {

		final Set<Integer> distinct = new HashSet<Integer>();
		for (int num : nums) {
			if (distinct.contains(num)) {
				return true;
			}
			distinct.add(num);
		}
		return false;
	}

	public boolean containsDuplicate2(int[] nums) {

		Arrays.sort(nums);
		for (int ind = 1; ind < nums.length; ind++) {
			if (nums[ind] == nums[ind - 1]) {
				return true;
			}
		}
		return false;
	}

	public boolean containsDuplicate3(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean containsDuplicate4(int[] nums) {

		return nums.length != Arrays.stream(nums).distinct().count();
	}

	public boolean containsDuplicate5(int[] nums) {
		Set<Integer> seen = new HashSet<>();
		return Arrays.stream(nums).anyMatch(num -> !seen.add(num));
	}

}
