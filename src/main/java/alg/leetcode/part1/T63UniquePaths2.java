package alg.leetcode.part1;

public class T63UniquePaths2 {

	public static void main(String[] args) {
		int[][] map = new int[3][3];
		// for (int[] rows : map) {
		// for (int i = 0; i < rows.length; i++) {
		// rows[i] = 0;
		// }
		// }
		map[1][1] = 1;
		System.out.println(new T63UniquePaths2().uniquePathsWithObstacles(map));
		// System.out.println(new T62UniquePaths().uniquePaths1(1, 50));
		// System.out.println(factorial(10));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length < 1)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					obstacleGrid[i][j] = 0;
				else if (i == 0 && j == 0)
					obstacleGrid[i][j] = 1 - obstacleGrid[i][j];
				else if (i == 0)
					obstacleGrid[i][j] = obstacleGrid[i][j - 1];
				else if (j == 0)
					obstacleGrid[i][j] = obstacleGrid[i - 1][j];
				else
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
			}
		}
		return obstacleGrid[m - 1][n - 1];

	}

	// 非常精妙的解法，以列为单位往下计数
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int j = 0; j < width; j++) {
				if (row[j] == 1)
					dp[j] = 0;
				else if (j > 0)
					dp[j] += dp[j - 1];
			}
		}
		return dp[width - 1];
	}

}
