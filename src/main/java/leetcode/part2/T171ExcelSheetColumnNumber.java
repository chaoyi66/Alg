package leetcode.part2;

public class T171ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.out.println(titleToNumber("AAA"));
	}

	public static int titleToNumber(String s) {
		int rs = 0;
		for (int i = 0; i < s.length(); i++) {
			rs = rs * 26 + s.charAt(i) - 'A' + 1;
		}
		return rs;
	}

}
