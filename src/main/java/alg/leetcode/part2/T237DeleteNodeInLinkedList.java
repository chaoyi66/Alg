package alg.leetcode.part2;

import alg.commons.ListNode;

public class T237DeleteNodeInLinkedList {

	public static void main(String[] args) {
		System.out.println();
	}

	public void deleteNode(ListNode node) {
	    node.val=node.next.val;
	    node.next=node.next.next;

	}

}
