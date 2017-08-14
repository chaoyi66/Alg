package commons;

public class MyArrayUtils {
	public static void swap(int[] nums, int i, int j) {
		if(i==j)
	        return;
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}
}
