package leetcode.part2;

import commons.ListNode;

public class T141LinkedListCycle {

	public static void main(String[] args) {
		System.out.println();
	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				return true;
		}
		return false;

	}

}
