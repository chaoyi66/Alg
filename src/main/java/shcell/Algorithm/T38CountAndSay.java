package shcell.Algorithm;

public class T38CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}

	// 暴力解法
	public static String countAndSay(int n) {
		String s = "1";
		for (int i = 1; i < n; i++) {
			int len = s.length();
			char say = s.charAt(0);
			int count = 0;
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < len; j++) {
				if (s.charAt(j) != say) {
					sb.append(count).append(say);
					say = s.charAt(j);
					count = 1;
				} else
					count++;
			}
			s = sb.append(count).append(say).toString();
		}
		return s;
	}
}
