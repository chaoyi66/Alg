package part2;

import shcell.commons.TreeNode;

public class T100SameTree {

	public static void main(String[] args) {
		System.out.println();
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		boolean pNull = p == null;
		boolean qNull = q == null;
		if (pNull && qNull)
			return true;
		else if (pNull || qNull)
			return false;
		else if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
			return true;
		else
			return false;

	}

	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}

}
