package alg.alg4.graph;

public class DepthFirstPaths extends Paths {

	public DepthFirstPaths(Graph G, int s) {
		super(G, s);
	}

	@Override
	void traverse(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				traverse(G, w);
			}

		}
		
	}

	

}
