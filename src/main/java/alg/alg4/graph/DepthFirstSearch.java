package alg.alg4.graph;

public class DepthFirstSearch {
	private boolean[] marked;
	private int count;

	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		marked[v]=true;
		System.out.println("move to new node: "+v);
		count++;
		for(int w:G.adj(v)){
			System.out.println("visit: "+w);
			if(!marked[w]){
//				System.out.println("visit: "+w);
				dfs(G, w);
			}
				
		}
		System.out.println("complete node: "+v);
	}
	
	public boolean marked(int w) {
		return marked(w);
	}
	
	public int  count() {
		return count;
	}

}
