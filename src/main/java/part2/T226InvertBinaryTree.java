package part2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import shcell.commons.TreeNode;

public class T226InvertBinaryTree {

	public static void main(String[] args) {
		System.out.println();
	}

	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			TreeNode tmp = root.left;
			root.left = invertTree(root.right);
			root.right = invertTree(tmp);
		}
		return root;
	}

	// The above solution is correct, but it is also bound to the
	// application stack, which means that it's no so much scalable - (you
	// can find the problem size that will overflow the stack and crash your
	// application), so more robust solution would be to use stack data
	// structure.

	public TreeNode invertTree1(TreeNode root) {

		if (root == null) {
			return null;
		}

		final Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			final TreeNode node = stack.pop();
			final TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		return root;
	}
	
//	Finally we can easly convert the above solution to BFS - or so called level order traversal.

	public TreeNode invertTree2(TreeNode root) {

        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

}
