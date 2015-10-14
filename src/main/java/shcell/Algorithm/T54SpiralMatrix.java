package shcell.Algorithm;

import java.util.ArrayList;
import java.util.List;

import shcell.commons.ListNode;

public class T54SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// int[][] matrix1 = new int[][] { { 1, 2, 3 } };

		System.out.println(spiralOrder1(matrix));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiralList = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return spiralList;

		// declare indices
		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;

		while (true) {
			// 1. print top row
			for (int j = left; j <= right; j++) {
				spiralList.add(matrix[top][j]);
			}
			top++;
			if (boundriesCrossed(left, right, bottom, top))
				break;

			// 2. print rightmost column
			for (int i = top; i <= bottom; i++) {
				spiralList.add(matrix[i][right]);
			}
			right--;
			if (boundriesCrossed(left, right, bottom, top))
				break;

			// 3. print bottom row
			for (int j = right; j >= left; j--) {
				spiralList.add(matrix[bottom][j]);
			}
			bottom--;
			if (boundriesCrossed(left, right, bottom, top))
				break;

			// 4. print leftmost column
			for (int i = bottom; i >= top; i--) {
				spiralList.add(matrix[i][left]);
			}
			left++;
			if (boundriesCrossed(left, right, bottom, top))
				break;
		} // end while true

		return spiralList;
	}

	private static boolean boundriesCrossed(int left, int right, int bottom, int top) {
		if (left > right || bottom < top)
			return true;
		else
			return false;
	}

	public static List<Integer> spiralOrder1(int[][] matrix) {
		List<Integer> spiralList = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return spiralList;

		// declare indices
		int top = 0;
		int btm = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;

		ListNode leftNode = new ListNode(left);
		ListNode btmNode = new ListNode(btm, leftNode);
		ListNode rightNode = new ListNode(right, btmNode);
		ListNode topNode = new ListNode(top, rightNode);
		leftNode.next = topNode;

		ListNode node = leftNode;
		while (true) {

			// 1. print top row
			for (int j = node.val; j <= node.next.next.val; j++) {
				spiralList.add(matrix[node.next.val][j]);
			}
			node.next.val++;
			if (boundriesCrossed(leftNode.val, rightNode.val, btmNode.val, topNode.val))
				break;

		} // end while true

		return spiralList;
	}

}
