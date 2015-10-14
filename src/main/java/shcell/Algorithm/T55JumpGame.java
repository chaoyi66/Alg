package shcell.Algorithm;

public class T55JumpGame {

	public static void main(String[] args) {
		// System.out.println(removeNthFromEnd2(1));
		int[] nums = new int[] { 1,1,1,0 };
		System.out.println(canJump1(nums));
	}

	public static boolean canJump(int[] nums) {
		int next = 0, span = 0, tmp = 0, cur = 0;
		while (span < nums.length - 1) {
			tmp = 0;
			for (int i = cur+1; i <= nums[cur]; i++) {
				if(i>=nums.length-1)
					return true;
				if (tmp < i + nums[i]) {
					tmp = i + nums[i];
					next = i;
				}
			}
			cur = next;
			if (tmp <= span)
				break;
			span=tmp;
		}
		return span >= nums.length - 1;
	}
//	暴力方法
	public static boolean canJump1(int[] nums) {
		int  span = 0;
		for (int i = 0; i < nums.length; i++) {
			if(span<i+nums[i])
				span=i+nums[i];
			else 
				return false;
			
			if(span>=nums.length-1)
				return true;
		}
		return false;
	}
}
