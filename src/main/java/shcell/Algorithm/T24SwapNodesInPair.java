package shcell.Algorithm;

import shcell.commons.ListNode;

/* Given a digit string, return all possible letter combinations that 
 * the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * */

public class T24SwapNodesInPair {

	// public static void main(String[] args) {
	//
	// }

	// 暴力解法
	public static ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode tmp = dummy;
		while (head != null) {
			ListNode tail = head.next;
			if (tail != null) {
				tmp.next = tail;
				head.next = tail.next;
				tail.next = head;
				tmp = head;
				head = head.next;
			} else
				break;
		}
		return dummy.next;
	}
	
	// 暴力解法
		public static ListNode swapPairs1(ListNode head) {
			ListNode dummy = new ListNode(0);
			dummy.next = head;
			ListNode tmp = dummy;
			while (head != null) {
				ListNode tail = head.next;
				if (tail != null) {
					tmp.next = tail;
					head.next = tail.next;
					tail.next = head;
					tmp = head;
					head = head.next;
				} else
					break;
			}
			return dummy.next;
		}
	
	
}
