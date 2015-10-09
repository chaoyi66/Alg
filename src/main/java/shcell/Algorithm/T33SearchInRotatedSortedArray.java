package shcell.Algorithm;

public class T33SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// System.out.println(removeNthFromEnd2(1));
	}

//	每次二分后总有一半是完全有序的，两边可以通过端点区分开来
	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[start] <= nums[mid]) {
				if (target < nums[mid] && target >= nums[start])
					end = mid - 1;
				else
					start = mid + 1;
			}
			if (nums[mid] <= nums[end]) {
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}

	// 递归版
	public static int search1(int[] nums, int target) {
		return searchRec(nums, target, 0, nums.length - 1);
	}

	public static int searchRec(int[] nums, int target, int lo, int hi) {
		if (lo > hi)
			return -1;
		int mid = (lo + hi) / 2;
		if (nums[mid] == target)
			return mid;
		if (nums[lo] <= nums[mid]) {
			if (target < nums[mid] && target >= nums[lo])
				return searchRec(nums, target, lo, mid - 1);
			else
				return searchRec(nums, target, mid + 1, hi);
		}
		if (nums[mid] <= nums[hi]) {
			if (target > nums[mid] && target <= nums[hi])
				return searchRec(nums, target, mid + 1, hi);
			else
				return searchRec(nums, target, lo, mid - 1);
		}
		return -1;
	}
}
