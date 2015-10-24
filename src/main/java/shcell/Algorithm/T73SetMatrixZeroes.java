package shcell.Algorithm;

import java.util.HashSet;
import java.util.Set;

public class T73SetMatrixZeroes {

	public static void main(String[] args) {
		// System.out.println();
	}

	public void setZeroes(int[][] matrix) {
		int rowLen = matrix.length;
		if (rowLen == 0)
			return;
		int colLen = matrix[0].length;
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		for (int row : rows) {
			for (int col = 0; col < colLen; col++) {
				matrix[row][col] = 0;
			}
		}
		for (int col : cols) {
			for (int row = 0; row < rowLen; row++) {
				matrix[row][col] = 0;
			}
		}
	}

	// O(1)空间的解法，以边界的0行0列作为标志位
	public void setZeroes1(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		boolean fr = false, fc = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						fr = true;
					if (j == 0)
						fc = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (fr) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
		if (fc) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	// 最简短的代码，思路跟第二种方法一样
	public void setZeroes2(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		boolean col0 = false;
		int rows = matrix.length, cols = matrix[0].length;

		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 0)
				col0 = true;
			for (int j = 1; j < cols; j++)
				if (matrix[i][j] == 0)
					matrix[i][0] = matrix[0][j] = 0;
		}

		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 1; j--)
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			if (col0)
				matrix[i][0] = 0;
		}
	}

}
