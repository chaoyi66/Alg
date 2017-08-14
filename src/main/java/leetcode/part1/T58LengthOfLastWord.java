package leetcode.part1;

public class T58LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World    "));
	}

	public static int lengthOfLastWord(String s) {
		int result = 0;
		boolean startFlag=false;
		for (int i = s.length() - 1;  i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				result++;
				startFlag=true;
			}else  if(startFlag)
				break;
		}
		return result;

	}
}
