package alg.alg4.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths extends Paths {

	public BreadthFirstPaths(Graph G, int s) {
		super(G, s);
	}

	@Override
	void traverse(Graph G, int s) {
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.offer(s);
		marked[s] = true;
		while(!queue.isEmpty()){
			int v=queue.poll();
			for(int w:G.adj(v)){
				if(marked[w]!=true){
					queue.offer(w);
					edgeTo[w]=v;
					marked[w]=true;
				}
			}
		}
	}

}
