package part2;

public class T283MoveZeroes {

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1, 0, 3, 12 };
		moveZeroes1(nums);
		System.out.println("555");
	}

	// 不保持原数组顺序
	public static void moveZeroes(int[] nums) {
		int index = nums.length - 1;
		int i = 0;
		while (i < index) {
			if (nums[i] == 0) {
				nums[i] = nums[index];
				nums[index--] = 0;
			}
			i++;
		}
	}

	public static void moveZeroes1(int[] nums) {
		if (nums == null || nums.length <2) return;        

	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0) nums[insertPos++] = num;
	    }        

	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
	
	public static void moveZeroes2(int[] nums) {
		int j = 0;
	    for(int i = 0; i < nums.length; i++) {
	        if(nums[i] != 0) {
	            int temp = nums[j];
	            nums[j] = nums[i];
	            nums[i] = temp;
	            j++;
	        }
	    }
	}

}
