package alg.alg4.graph;

import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
	private final int V;
	private int E;
	private LinkedList<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i]=new LinkedList<Integer>();
		}
	}

	public Graph(Scanner in) {
		this(in.nextInt());
		int E = in.nextInt();
		for (int i = 0; i < E; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			addEdge(v, w);
		}
	}

	void addEdge(int v, int w) {

		adj[w].add(v);
		adj[v].add(w);
		this.E++;
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}
