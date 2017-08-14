package alg.alg4.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	private boolean[] marked;

	public BreadthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		bfs(G, s);
	}

	private void bfs(Graph G, int s) {
		marked[s] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(s);
		while (!queue.isEmpty()) {
			int v = queue.poll();
			System.out.println("move to new node: "+v);
			for (int w : G.adj(v)) {
				System.out.println("visit: " + w);
				if (marked[w] != true) {
					marked[w] = true;
					queue.offer(w);
				}

			}
			System.out.println("complete node: "+v);

		}
	}

}
