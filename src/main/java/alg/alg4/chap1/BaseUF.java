package alg.alg4.chap1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BaseUF extends UF {

	public BaseUF(int N) {
		super(N);
	}

	@Override
	void union(int p, int q) {
		int pId = id[p];
		int qId = id[q];
		if (pId != qId) {
			count--;
		}
		for (int i = 0; i < id.length; i++) {
			if (id[i] == qId)
				id[i] = pId;
		}
	}

	@Override
	int find(int p) {
		return id[p];
	}

	public static void main1(String[] args) throws FileNotFoundException {
//		String fileName="tinyUf";
//		String fileName="mediumUF";
		String fileName="largeUF";

		Scanner sc = new Scanner(new File("C:\\study\\GitRepository\\algs4\\src\\chap1\\"+fileName+".txt"));
		long t1=System.currentTimeMillis();
		int N = sc.nextInt();
		BaseUF buf = new BaseUF(N);
		while (sc.hasNextLine()) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			buf.union(p, q);
		}
		long t2=System.currentTimeMillis();
		System.out.println("Time cost is:"+(t2-t1));
		System.out.println("There are " + buf.count + " components");

	}
}
