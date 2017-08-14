package alg.alg4.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StartTest {
	public static String resPath = "C:\\study\\GitHub\\StudyAlgs\\algs4\\res\\";

	public static void main(String[] args) throws FileNotFoundException {

		File f = new File(resPath + "tinyG.txt");
		Scanner sc = new Scanner(f);

		Graph G = new Graph(sc);
		int s = 0;

		// searchCmp(G, s);
		// pathCmp(G, s);
		// testCC(G);
		// testCycle(G);
		testSymbolGraph(new File(resPath + "routes.txt"), " ");

	}

	private static void searchCmp(Graph G, int s) {
		System.out.println("*******DFS********");
		new DepthFirstSearch(G, s);
		System.out.println("******BFS*********");
		new BreadthFirstSearch(G, s);
		System.out.println("***************");
	}

	private static void pathCmp(Graph G, int s) {
		DepthFirstPaths dfp = new DepthFirstPaths(G, s);
		BreadthFirstPaths bfp = new BreadthFirstPaths(G, s);

		for (int v = 0; v < G.V(); v++) {
			System.out.println("^^^^^^dfp Path: ");
			dfp.printPath(v);
			System.out.println("******bfp Path: ");
			bfp.printPath(v);
			System.out.println();
		}
	}

	private static void testCC(Graph G) {
		ConnectedComponent cc = new ConnectedComponent(G);
		cc.printAllComponents();
		cc.printComponent(3);
	}

	private static void testCycle(Graph G) {
		Cycle c = new Cycle(G);
		System.out.println("Has cycle? " + c.hasCycle());

	}

	private static void testSymbolGraph(File f, String sp) throws FileNotFoundException {
		new SymbolGraph(f, sp);

	}

}
