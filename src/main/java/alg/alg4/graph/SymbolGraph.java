package alg.alg4.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class SymbolGraph {
	private HashMap<String, Integer> st;
	private String[] keys;
	private Graph G;

	@SuppressWarnings({ "unused", "resource" })
	public SymbolGraph(File f, String sp) throws FileNotFoundException {
		System.out.println("Construction start!");

		st = new HashMap<String, Integer>();
		Scanner in = new Scanner(f);
		while (in.hasNextLine()) {
			String[] strs = in.nextLine().split(sp);
			for (String key : strs) {
				if (!st.containsKey(key)) {
					st.put(key, st.size());
				}
			}
		}
		keys = new String[st.size()];
		for (String name : st.keySet()) {
			keys[st.get(name)] = name;
		}

		Scanner in2 = new Scanner(f);
		G = new Graph(st.size());
		while (in2.hasNextLine()) {
			String[] a = in2.nextLine().split(sp);
			int v = st.get(a[0]);
			for (int i = 1; i < a.length; i++) {
				G.addEdge(v, st.get(a[i]));
			}
		}
		System.out.println("Construction complete!");

	}

	public boolean contains(String s) {
		return st.containsKey(s);
	}

	public int index(String s) {
		return st.get(s);

	}

	public String name(int v) {
		return keys[v];
	}

	public Graph G() {
		return G;
	}

}
