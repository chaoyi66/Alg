package alg.alg4.chap1;

public class WeightedQuickUF extends UF {

	private int[] sz;

	public WeightedQuickUF(int N) {
		super(N);
		sz = new int[N];
		for (int i = 0; i < id.length; i++) {
			sz[i] = 1;
		}
	}

	@Override
	void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot)
			return;
		if (sz[pRoot] > sz[qRoot]) {
			id[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}
		else {
			id[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		}
		count--;
	}

	@Override
	int find(int p) {
		while (id[p] != p) {
			p = id[p];
		}
		return p;
	}
	
}
