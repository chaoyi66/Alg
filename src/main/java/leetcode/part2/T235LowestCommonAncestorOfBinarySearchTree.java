package leetcode.part2;

import commons.TreeNode;

public class T235LowestCommonAncestorOfBinarySearchTree {

	public static void main(String[] args) {
		System.out.println();
	}

	// 二叉搜索树一定是左小右大的
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0)
			root = p.val < root.val ? root.left : root.right;
		return root;
	}

	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		return (root.val - p.val) * (root.val - q.val) < 1 ? root
				: lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
	}

}
