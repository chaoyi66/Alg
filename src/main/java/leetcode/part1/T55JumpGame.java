package leetcode.part1;

public class T55JumpGame {

	public static void main(String[] args) {
		// System.out.println(removeNthFromEnd2(1));
		int[] nums = new int[] { 2,1,0,0 };
		System.out.println(canJump(nums));
	}

	public static boolean canJump(int[] nums) {
		int cur = 0, next = 0, span = 0;
		while (cur < nums.length) {
			int maxStep = nums[cur];
			for (int i = cur + 1; i <= maxStep + cur; i++) {
				if (i >= nums.length - 1)
					return true;
				if (nums[i] + i >= span) {
					span = nums[i] + i;
					next = i;
				}
			}
			if (cur == span)
				break;
			else
				cur = next;
		}
		return span >= nums.length - 1;
	}

	// 暴力方法
	public boolean canJump1(int[] nums) {
	    int reachable = 0;
	    for (int i=0; i<nums.length; ++i) {
	        if (i > reachable) return false;
	        reachable = Math.max(reachable, i + nums[i]);
	    }
	    return true;
	}
}
