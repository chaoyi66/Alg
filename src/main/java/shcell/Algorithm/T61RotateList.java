package shcell.Algorithm;

import shcell.commons.ListNode;

public class T61RotateList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2));
		int k = 1;
		System.out.println(rotateRight(head, k));
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return head;
		int count = 0;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null) {
			cur = cur.next;
			count++;
		}
		k = k % count; // 归一化的[0,count)区间
		if (k == 0) {
			return head;
		}

		ListNode front = dummy;
		ListNode back = dummy;
		for (int i = 0; i < k; i++) {
			front = front.next;
			if (front.next == null)
				return head;

		}
		while (front.next != null) {
			front = front.next;
			back = back.next;
		}
		head = back.next;
		back.next = null;
		front.next = dummy.next;
		return head;
	}

}
