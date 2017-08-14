package leetcode.part2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T169MajorityElement {
	// 我们经常在面试中遇到这道题：
	// 给定一个数组nums, 找出可能的众数(即出现次数超过一半的数字)
	//
	// 这个题一种解法是配对比较的方法，即将其两两配对，如果相等则保留任意一个，
	// 如果不等则都舍去。如果存在众数，那最后剩下的一定是。至于是否存在众数，
	// 只需要将最后剩下的那个数遍历一遍数组，看出现次数是否超过一半即可。当然这种方法对于数组元素为奇数的情况要稍微处理下，
	// 因为没法两两配对，我们需要先检测一个数字是否是众数，如果是则返回，不是将其舍去化为偶数的情况。
	//
	// 另外一种解法是用Moore’s voting algorithm，
	// 这个方法本质和上面的方法类似。但是写起来更简单，而且不用奇偶讨论，关键的是这是一个在线算法，
	// 即它不仅可以处理数组，即使输入是一个不知道长度的流(stream)，
	// 也可以在读完流的时候返回众数(当然前提是众数必须存在，如果不确定是否存在则需要将流遍历两遍，
	// 第一遍找出潜在的众数，第二遍检测这个潜在的众数是不是真的众数)。具体方法为：
	//
	// 我们用一个数a记录当前潜在的众数,
	// times记录次数初始为0，然后从左到右遍历数组，如果nums[i]和a相等，则times++(类似于第一种算法相等保留任意一个)；
	// 不等则times– (类似于不等则都舍去一个)，并且times = 0 时将 a = nums[i]且times =
	// 1。当遍历到数组末尾是，如果数组中存在众数，则一定是a，最后只需要再遍历一遍数组确认一下即可。

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 2, 3 }));
	}

	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		int count = 1;
		int i = 1;
		for (; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				count++;
			else {
				if (count > len / 2) {
					break;
				} else {
					count = 1;
				}
			}
		}
		return nums[i - 1];

	}

	// Hashtable
	public int majorityElement2(int[] nums) {
		Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		// Hashtable<Integer, Integer> myMap = new Hashtable<Integer,
		// Integer>();
		int ret = 0;
		for (int num : nums) {
			if (!myMap.containsKey(num))
				myMap.put(num, 1);
			else
				myMap.put(num, myMap.get(num) + 1);
			if (myMap.get(num) > nums.length / 2) {
				ret = num;
				break;
			}
		}
		return ret;
	}

	// Moore voting algorithm
	public int majorityElement3(int[] nums) {
		int count = 0, ret = 0;
		for (int num : nums) {
			if (count == 0)
				ret = num;
			if (num != ret)
				count--;
			else
				count++;
		}
		return ret;
	}

	// Bit manipulation
	public int majorityElement4(int[] nums) {
		int[] bit = new int[32];
		for (int num : nums)
			for (int i = 0; i < 32; i++)
				if ((num >> (31 - i) & 1) == 1)
					bit[i]++;
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
			ret += bit[i] * (1 << (31 - i));
		}
		return ret;
	}

}
