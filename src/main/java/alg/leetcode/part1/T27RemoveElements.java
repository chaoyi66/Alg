package alg.leetcode.part1;

import java.util.Arrays;

public class T27RemoveElements {

	 public static void main(String[] args) {
		 int[] a=new int[]{1,1,121};
		 System.out.println(removeElement(a,1));
		 System.out.println(Arrays.toString(a));
	 }

	// 暴力解法
	public static int removeElement(int[] nums, int val) {		
		int i=0,j=nums.length-1;
		while(i<=j){
			if(nums[i]==val){			
				nums[i--]=nums[j--];
			}
			i++;			
		}
		return i;
	}
}
