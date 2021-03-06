package cc;

import java.io.BufferedReader;
import java.io.FileReader;

public class InputStreamTest {

	private static String read(String filename) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String s;
		StringBuffer sb = new StringBuffer();
		while ((s = br.readLine()) != null) {
			sb.append(s + "\n");
		}
		br.close();
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		read("src/InputStreamTest.java");
	}
}