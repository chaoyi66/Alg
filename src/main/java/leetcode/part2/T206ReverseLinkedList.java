package leetcode.part2;

import commons.ListNode;

public class T206ReverseLinkedList {

	public static void main(String[] args) {
		System.out.println();
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode nextNode = head.next;
		ListNode newHead = reverseList(nextNode);
		nextNode.next = head;
		head.next = null;
		return newHead;

	}

}
