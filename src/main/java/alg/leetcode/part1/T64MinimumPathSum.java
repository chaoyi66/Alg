package alg.leetcode.part1;

public class T64MinimumPathSum {

	public static void main(String[] args) {
		int[][] map = new int[][] { { 1, 2 }, { 1, 1 } };
		System.out.println(minPathSum1(map));
		// System.out.println(removeNthFromEnd2(1));
	}

	int maxRow;
	int maxCol;
	int min;

	public int minPathSum(int[][] grid) {
		maxRow = grid.length;
		maxCol = grid[0].length;
		min = Integer.MAX_VALUE;
		dfs(grid, 0, 0, 0);
		return min;
	}

	private void dfs(int[][] grid, int sum, int m, int n) {
		if (m >= maxRow || n >= maxCol)
			return;
		sum += grid[m][n];
		if (m == maxRow - 1 && n == maxCol - 1 && sum < min) {
			min = sum;
			return;
		}
		if (sum >= min)
			return;
		dfs(grid, sum, m + 1, n);
		dfs(grid, sum, m, n + 1);
	}

	// 动态规划，求出每个节点的最短路径，然后每个节点只能由左边或者上边的点到达，选择比较小的一个与当前节点相加，则是最小和
	public static int minPathSum1(int[][] grid) {
		int maxRow = grid.length;
		int maxCol = grid[0].length;
		int[][] newGrid = new int[maxRow + 1][maxCol + 1];
		for (int i = 1; i <= maxRow; i++) {
			for (int j = 1; j <= maxCol; j++) {
				if (i == 1)
					newGrid[i][j] = newGrid[i][j - 1] + grid[i - 1][j - 1];
				else if (j == 1)
					newGrid[i][j] = newGrid[i - 1][j] + grid[i - 1][j - 1];
				else
					newGrid[i][j] = Math.min(newGrid[i - 1][j], newGrid[i][j - 1])
							+ grid[i - 1][j - 1];
			}
		}
		return newGrid[maxRow][maxCol];
	}

}
