package alg.alg4.graph;

import java.util.Stack;

public abstract class Paths {
	protected boolean[] marked;
	protected int[] edgeTo;
	private final int s;
	protected Graph G;

	public Paths(Graph G, int s) {
		this.marked = new boolean[G.V()];
		this.edgeTo = new int[G.V()];
		this.s = s;
		this.G = G;
		traverse(G, s);
	}

	abstract void traverse(Graph G, int s);

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Stack<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}

	public void printPath(int v) {
		if (hasPathTo(v)) {
			System.out.printf("%d to %d:  ", s, v);
			Stack<Integer> path = pathTo(v);
			while (!path.empty()) {
				int x = path.pop();
				if (x == s)
					System.out.print(x);
				else
					System.out.print("-" + x);
			}
			System.out.println();
		}

		else {
			System.out.printf("%d to %d:  not connected\n", s, v);
		}
	}

}
