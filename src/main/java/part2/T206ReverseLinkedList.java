package part2;

import shcell.commons.ListNode;

public class T206ReverseLinkedList {

	public static void main(String[] args) {
		System.out.println();
	}

	public ListNode reverseList(ListNode head) {
		if (head==null) {
			return null;
		}
		ListNode cur = head;
		ListNode next = cur.next;
		ListNode before=new ListNode(0);
		before.next=cur;
		while (next != null) {
			ListNode tmp = next.next;
			next.next = cur;
			cur = next;
			next = tmp;
		}
		return cur;
	}

}
