package alg.leetcode.part2;

import alg.commons.ListNode;

public class T83RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		// head.next.next.next = new ListNode(2);
		// head.next.next.next.next = new ListNode(2);
		System.out.println(deleteDuplicates(head));
	}

	public static ListNode deleteDuplicates1(ListNode head) {
		ListNode p = head;
		while (p != null) {
			while (p.next != null && p.val == p.next.val) {
				p.next = p.next.next;
			}
			p = p.next;
		}
		return head;
	}

	public ListNode deleteDuplicates2(ListNode head) {
		ListNode current = head;
		while (current != null && current.next != null)
			if (current.next.val > current.val)
				current = current.next;
			else
				current.next = current.next.next;
		return head;
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
	}

}
