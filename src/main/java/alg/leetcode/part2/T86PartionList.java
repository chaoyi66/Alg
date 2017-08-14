package alg.leetcode.part2;

import alg.commons.ListNode;

public class T86PartionList {

	public static void main(String[] args) {

		System.out.println(partition(new ListNode(2, new ListNode(1, new ListNode(-1))), 2));
	}

	public static ListNode partition(ListNode head, int x) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode node = dummy;
		ListNode smaller = new ListNode(0);
		ListNode ps = smaller;
		ListNode larger = new ListNode(0);
		ListNode pl = larger;
		while (node.next != null) {
			node = node.next;
			if (node.val >= x) {
				pl.next = node;
				pl = pl.next;
			} else {
				ps.next = node;
				ps = ps.next;
			}
		}

		pl.next = null;// 避免环状
		
		ps.next = larger.next;
		return smaller.next;

	}

}
