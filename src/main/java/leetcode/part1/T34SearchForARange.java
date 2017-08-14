package leetcode.part1;

public class T34SearchForARange {

	public static void main(String[] args) {
		// System.out.println(removeNthFromEnd2(1));
	}

	// 暴力解法,二分法找到某个点之后再往左右一个个测试，复杂度可能到O(N)
	public int[] searchRange(int[] nums, int target) {
		int len = nums.length;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				start = mid;
				end = mid;
				while (start >= 0 && nums[start] == nums[mid])
					start--;
				while (end < len && nums[end] == nums[mid])
					end++;
				return new int[] { ++start, --end };
			} else if (nums[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return new int[] { -1, -1 };
	}

	// 真正的O(logN)
	public int[] searchRange1(int[] A, int target) {
		int start = firstGreaterEqual(A, target);
		if (start == A.length || A[start] != target) {
			return new int[] { -1, -1 };
		}
		return new int[] { start, firstGreaterEqual(A, target + 1) - 1 };
	}

	// find the first number that is greater than or equal to target.
	// could return A.length if target is greater than A[A.length-1].
	// actually this is the same as lower_bound in C++ STL.
	private static int firstGreaterEqual(int[] A, int target) {
		int low = 0, high = A.length;
		while (low < high) {
			int mid = low + ((high - low) / 2);
			// low <= mid < high
			if (A[mid] < target) {
				low = mid + 1;
			} else {
				// should not be mid-1 when A[mid]==target.
				high = mid;
			}
		}
		return low;
	}
}
