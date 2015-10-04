package shcell.Algorithm;

import shcell.commons.ListNode;

/* Given a digit string, return all possible letter combinations that 
 * the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * */

public class T21MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode l11 = new ListNode(0);
		ListNode l12 = new ListNode(1);
		ListNode l21 = new ListNode(2);
		ListNode l22 = new ListNode(3);
		l11.next = l21;
		l12.next = l22;
		System.out.println(mergeTwoLists3(l11, l12));

	}

	// 暴力解法
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		while (l1 != null || l2 != null) {
			while (l1 != null && (l2 == null || l1.val <= l2.val)) {
				node.next = l1;
				l1 = l1.next;
				node = node.next;
			}
			while (l2 != null && (l1 == null || l2.val <= l1.val)) {
				node.next = l2;
				l2 = l2.next;
				node = node.next;
			}
		}
		return dummy.next;

	}

	// 论坛里的解法，当某个链表为空后，另一个不需要再遍历了
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode prev = result;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		if (l1 != null) {
			prev.next = l1;
		}
		if (l2 != null) {
			prev.next = l2;
		}
		return result.next;
	}

	// 递归版本，非尾递归版本，可能堆栈溢出
	public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l2.next, l1);
			return l2;
		}
	}
}
