package leetcode.part1;

/* Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i 
 * is at (i, ai) and (i, 0). Find two lines, which together with 
 * x-axis forms a container, such that the container contains the 
 * most water.
 * 
 * Note: You may not slant the container.
*/

public class T11ContainerWithMostWater {

	public static void main(String[] args) {

	}

	// 暴力解法
	public int maxArea1(int[] height) {
		int len = height.length;
		int max = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				int tmp = Math.abs(i - j) * Math.min(height[i], height[j]);
				if (max < tmp)
					max = tmp;
			}
		}
		return max;
	}

	// O(n)解法
	public int maxArea(int[] height) {
		int maxWater = 0, left = 0, right = height.length - 1;
		while (left < right) {
			maxWater = Math.max(maxWater, (right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return maxWater;
	}

}
