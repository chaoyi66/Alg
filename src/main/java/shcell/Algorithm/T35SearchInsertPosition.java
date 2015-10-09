package shcell.Algorithm;

public class T35SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 6, 7, 8, 9 };
		int target = 5;
		System.out.println(searchInsert1(nums, target));
	}

	// 暴力解法
	public static int searchInsert(int[] nums, int target) {
		int len = nums.length;
		if (len == 0)
			return 0;
		if (target <= nums[0])
			return 0;
		if (target > nums[nums.length - 1])
			return nums.length;
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target) {
				lo = mid + 1;
				if (nums[mid + 1] >= target)
					return mid + 1;
			} else {
				hi = mid - 1;
				if (nums[mid - 1] < target)
					return mid;
			}
		}
		return 0;
	}

	// 二分法结束时，没找到目标值的情况下lo=high
	public static int searchInsert1(int[] nums, int target) {
		int len = nums.length;
		if (len == 0)
			return 0;
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return nums[lo] < target ? lo + 1 : lo;
	}
}
