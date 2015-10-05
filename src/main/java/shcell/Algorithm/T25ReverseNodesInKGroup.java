package shcell.Algorithm;

import java.util.Stack;

import shcell.commons.ListNode;

/* Given a digit string, return all possible letter combinations that 
 * the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * */

public class T25ReverseNodesInKGroup {

	public static void main(String[] args) {
		int k = 6;
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		System.out.println(head);
		System.out.println(reverseKGroup1(head, k));

	}

	// 递归解法，内存O(n)超限
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1)
			return head;
		Stack<ListNode> stack = new Stack<>();
		ListNode tmp = head;
		for (int i = 1; i <= k; i++) {
			if (tmp == null)
				return head;
			stack.push(tmp);
			tmp = tmp.next;
		}
		ListNode tail = stack.pop();
		head.next = reverseKGroup(tail.next, k);
		tmp = tail;
		while (!stack.isEmpty()) {
			tmp.next = stack.pop();
			tmp = tmp.next;
		}
		return tail;
	}

	// 递归解法，内存O(1)
	public static ListNode reverseKGroup1(ListNode head, int k) {
		if (head == null || k <= 1)
			return head;
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode tmp = head, tail = head, after = head.next;
		for (int i = 1; i <= k; i++) {
			if (tmp == null) {
				return head;
			}
			tmp = tmp.next;
		}
		tmp = head;
		for (int i = 1; i <= k - 1; i++) {
			tmp.next = pre;
			pre = tmp;
			tmp = after;
			after = after.next;
		}
		tail = tmp;
		tail.next = pre;
		head.next = reverseKGroup(after, k);
		return tail;

	}
}
