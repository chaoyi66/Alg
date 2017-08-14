package leetcode.part2;

import commons.TreeNode;

public class T104MaximumDepthBinaryTree {

	public static void main(String[] args) {
		System.out.println();
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		else
			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

}
