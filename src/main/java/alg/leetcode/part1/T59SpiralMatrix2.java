package alg.leetcode.part1;

public class T59SpiralMatrix2 {

	public static void main(String[] args) {
		System.out.println(generateMatrix(2));
	}

	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int top = 0, btm = n - 1, left = 0, right = n - 1;
		int count = 1;
		while (count <= n * n) {
			for (int i = left; i <= right && count <= n * n; i++) {
				matrix[top][i] = count++;
			}
			top++;

			for (int i = top; i <= btm && count <= n * n; i++) {
				matrix[i][right] = count++;
			}
			right--;

			for (int i = right; i >= left && count <= n * n; i--) {
				matrix[btm][i] = count++;
			}
			btm--;

			for (int i = btm; i >= top && count <= n * n; i--) {
				matrix[i][left] = count++;
			}
			left++;

		}
		return matrix;
	}

}
