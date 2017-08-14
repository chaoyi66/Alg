package alg.alg4.chap1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickUF extends UF {

	public QuickUF(int N) {
		super(N);
	}

	@Override
	void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot != qRoot) {
			id[qRoot] = pRoot;
			count--;
		}
	}

	@Override
	int find(int p) {
		while (id[p] != p) {
			p = id[p];
		}
		return p;
	}

	public static void main1(String[] args) throws FileNotFoundException {
//		String fileName = "tinyUf";
//		 String fileName="mediumUF";
		 String fileName="largeUF";

		System.out.println("QuickUF begin");
		Scanner sc = new Scanner(new File("C:\\study\\GitRepository\\algs4\\src\\chap1\\" + fileName + ".txt"));
		long t1 = System.currentTimeMillis();
		int N = sc.nextInt();
		QuickUF buf = new QuickUF(N);
		int i=0;
		while (sc.hasNextLine()) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			buf.union(p, q);
			System.out.println("i="+i++);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Time cost is:" + (t2 - t1));
		System.out.println("There are " + buf.count + " components");
	}
}
