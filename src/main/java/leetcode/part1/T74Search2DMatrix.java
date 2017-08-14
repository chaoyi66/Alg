package leetcode.part1;

public class T74Search2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 3 } };
		int target = 3;
		System.out.println(searchMatrix(matrix, target));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int lo = 0, hi = m * n - 1, mid = 0;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (matrix[mid / n][mid % n] == target)
				return true;
			if (matrix[mid / n][mid % n] > target)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return false;

	}
}
