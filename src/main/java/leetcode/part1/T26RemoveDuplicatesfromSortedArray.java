package leetcode.part1;

import java.util.Arrays;

public class T26RemoveDuplicatesfromSortedArray {

	 public static void main(String[] args) {
		 int[] a=new int[]{1,1,2,3,3};
		 System.out.println(removeDuplicates(a));
		 System.out.println(Arrays.toString(a));
	 }

	// 暴力解法
	public static int removeDuplicates(int[] nums) {
		if(nums.length<=1)
			return nums.length;
		int p=1;
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]!=nums[i+1]){
				nums[p++]=nums[i+1];
			}
		}
		return  p;
	}
}
