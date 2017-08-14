package leetcode.part2;

import commons.TreeNode;

public class T110BalancedBinaryTree {

	public static void main(String[] args) {
		System.out.println();
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(height(root.left) - height(root.right)) <= 1)
			return (isBalanced(root.left) && isBalanced(root.right));
		return false;
	}

	public int height(TreeNode root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		return (Math.max(left, right) + 1);

	}

	public boolean isBalanced1(TreeNode root) {
		return getDepth(root) != -1;
	}

	public int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getDepth(root.left);
		if (left != -1) {
			int right = getDepth(root.right);
			if (right != -1) {
				return Math.abs(left - right) <= 1 ? 1 + Math.max(left, right) : -1;
			}
		}
		return -1;
	}

}
