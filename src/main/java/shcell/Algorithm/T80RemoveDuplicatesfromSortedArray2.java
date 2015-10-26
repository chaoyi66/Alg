package shcell.Algorithm;

public class T80RemoveDuplicatesfromSortedArray2 {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,1,2,3}));
	}

	public static int removeDuplicates(int[] nums) {
		int len=nums.length;
		if (len<=0) 
			return len;
		int count=0;
		int tmp=nums[0];
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==tmp){
				if(++count>2)
					len--;
			}else {
				count=1;
				tmp=nums[i];
			}		
		}
		return len;
	}
	
//	简洁解法
	public int removeDuplicates1(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i < 2 || n > nums[i-2])
	            nums[i++] = n;
	    return i;
	}

}
