package alg.leetcode.part1;

public class T62UniquePaths {

	public static void main(String[] args) {
		System.out.println(new T62UniquePaths().uniquePaths(2, 1));
		// System.out.println(new T62UniquePaths().uniquePaths1(1, 50));
		// System.out.println(factorial(10));
	}

	// 动态规划
	public int uniquePaths(int m, int n) {
		int[][] map = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0) {
					map[i][j] = 1;
					continue;
				}
				if (j == 0) {
					map[i][j] = 1;
					continue;
				}
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		return map[m - 1][n - 1];
	}

	// 深度优先遍历
	private int count = 0;

	public int uniquePaths1(int m, int n) {
		dfs(m, n, 1, 1);
		return count;
	}

	private void dfs(int m, int n, int x, int y) {
		if (x == m || y == n) {
			count++;
			return;
		}
		if (x > m || y > n)
			return;
		dfs(m, n, x + 1, y);
		dfs(m, n, x, y + 1);
	}

	// 直接数学计算
	public long uniquePaths2(long x, long y) {
		return factorial(x + y - 2) / factorial(x - 1) / factorial(y - 1);
	}

	public static long factorial(long n) {
		if (n == 1 || n == 0)
			return 1;
		return factorial(n - 1) * n;
	}

}
