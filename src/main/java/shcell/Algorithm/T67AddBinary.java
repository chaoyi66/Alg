package shcell.Algorithm;

public class T67AddBinary {

	public static void main(String[] args) {
		System.out.println(addBinary("0", "1"));
	}

	public static String addBinary(String a, String b) {
		if (a == null || a.isEmpty())
			return b;
		if (b == null || b.isEmpty())
			return a;

		int lenA = a.length(), lenB = b.length();
		int len = Math.max(lenA, lenB) + 1;
		int[] nums = new int[len];
		int carry = 0;
		for (int i = 0; i < nums.length; i++) {
			int va = (i >= lenA ? 0 : a.charAt(lenA - 1 - i) - '0');
			int vb = (i >= lenB ? 0 : b.charAt(lenB - 1 - i) - '0');
			nums[len - 1 - i] = (va + vb + carry) % 2;
			carry = (va + vb + carry) / 2;
		}
		StringBuilder s = new StringBuilder();
		if (nums[0] == 1 || len == 1)
			s.append(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			s.append(nums[i]);
		}
		return s.toString();
	}

//	简洁版
	public String addBinary1(String a, String b) {
		if (a == null || a.isEmpty())
			return b;
		if (b == null || b.isEmpty())
			return a;
	    int lena = a.length();
	    int lenb = b.length();
	    int i =0, carry = 0;
	    String res = "";
	    while(i<lena || i<lenb || carry!=0){
	        int x = (i<lena) ? Character.getNumericValue(a.charAt(lena - 1 - i)) : 0;
	        int y = (i<lenb) ? Character.getNumericValue(b.charAt(lenb - 1 - i)) : 0;
	        res = (x + y + carry)%2 + res;
	        carry = (x + y + carry)/2;
	        i++;
	    }
	    return res;
	}
}
