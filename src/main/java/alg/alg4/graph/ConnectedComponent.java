package alg.alg4.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class ConnectedComponent {
	private int[] cIdArray;
	private int count = 0;

	public ConnectedComponent(Graph G) {
		this.cIdArray = new int[G.V()];
		Arrays.fill(cIdArray, 0);
		for (int i = 0; i < G.V(); i++) {
			if (cIdArray[i] == 0) {
				cIdArray[i] = ++count;
				dfs(G, i);
			}

		}

	}

	private void dfs(Graph G, int v) {
		for (int w : G.adj(v)) {
			if (cIdArray[w] == 0) {
				cIdArray[w] = count;
				dfs(G, w);
			}
		}
	}

	public int[] getCidArray() {
		for (int i : cIdArray) {
			System.out.println(i);
		}
		return cIdArray;
	}

	public int count() {
		return count;
	}

	public LinkedList<Integer> printComponent(int cId) {
		System.out.println("component " + cId + ": ");
		LinkedList<Integer> component = new LinkedList<Integer>();

		for (int i = 0; i < cIdArray.length; i++) {
			if (cIdArray[i] == cId) {
				System.out.print(i + "\t");
				component.add(i);
			}
		}
		return component;
	}

	public void printAllComponents() {
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] components = new LinkedList[count()];
		for (int i = 0; i < components.length; i++)
			components[i] = new LinkedList<Integer>();
		for (int i = 0; i < cIdArray.length; i++) {
			int cId = cIdArray[i];
			components[cId - 1].add(i);
		}
		System.out.println("*******components********");
		int i = 0;
		for (LinkedList<Integer> component : components) {
			System.out.println("component " + (++i) + " : ");
			for (int node : component) {
				System.out.print(node + "  ");
			}
			System.out.println();
		}
		System.out.println("**********end***********");

	}

}
