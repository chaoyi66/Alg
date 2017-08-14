package alg.alg4.chap1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		// String fileName = "tinyUf";
//		String fileName = "mediumUF";
		 String fileName = "largeUF";

		System.out.println("QuickUF begin");
		Scanner sc = new Scanner(new File("C:\\study\\GitRepository\\algs4\\src\\chap1\\" + fileName + ".txt"));
		long t1 = System.currentTimeMillis();
		int N = sc.nextInt();
		
//		UF buf = new BaseUF(N);
//		UF buf = new QuickUF(N);
		UF buf = new WeightedQuickUF(N);
		int i = 0;
		while (sc.hasNextLine()) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			buf.union(p, q);
			System.out.println("i=" + i++);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Time cost is:" + (t2 - t1));
		System.out.println("There are " + buf.count + " components");
	}
}
