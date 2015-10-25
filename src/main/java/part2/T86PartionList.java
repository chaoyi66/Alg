package part2;

import shcell.commons.ListNode;

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
			ListNode tmp = node;
			node = node.next;
			tmp.next = null;
			if (node.val >= x) {
				pl.next = node;
				pl = pl.next;
			} else {
				ps.next = node;
				ps = ps.next;
			}
		}
		if (smaller.next != null) {
			head = smaller.next;
			ps.next = larger.next;
		} else if (larger.next != null)
			head = larger.next;
		return head;

	}

}
