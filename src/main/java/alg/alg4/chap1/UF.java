package alg.alg4.chap1;

public abstract class UF {
	protected  int count;
	protected int[] id;
	
	public UF(int N) {
		count=N;
		id=new int[N];
		for (int i = 0; i < id.length; i++) {
			id[i]=i;
		}
	}

	abstract void union(int p, int q);

	abstract int find(int p);

	boolean connected(int p, int q) {
		return find(p)==find(q);
	}

	int count() {
		return count;
	}
}
