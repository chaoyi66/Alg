package alg.alg4.graph;

import java.util.Arrays;

public class Cycle {
	private boolean[] marked;
	private boolean hasCycle;
	
	 public Cycle(Graph G) {
		marked=new boolean[G.V()];
		Arrays.fill(marked, false);
		hasCycle=false;
		for (int i = 0; i < marked.length; i++) {
			if(!marked[i])
				dfs(G, i, i);
		}
		
	}
	 
	 private void dfs(Graph G,int u,int v) {
		marked[v]=true;
		for(int w:G.adj(v)){
			if(!marked[w])
				dfs(G,v, w);
			else if(w!=u){
				hasCycle=true;
			}
				
		}
	}
	 
	 public boolean hasCycle() {
		return hasCycle;
	}
}
