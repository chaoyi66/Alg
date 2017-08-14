package alg.leetcode.part1;

import alg.commons.ListNode;

/*You are given two linked lists representing two 
 * non-negative numbers. The digits are stored 
 * in reverse order and each of their nodes contain a 
 * single digit. Add the two numbers and return it as a 
 * linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8*/

public class T02AddTwoNumber {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p = new ListNode(-1), start = p;
		int tmp = 0;
		while (l1 != null || l2 != null || tmp != 0) {
			if (l1 != null) {
				tmp += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				tmp += l2.val;
				l2 = l2.next;
			}
			p.next = new ListNode(tmp % 10);
			tmp = tmp / 10;
			p = p.next;
		}
		return start.next;

	}
}
