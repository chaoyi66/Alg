package leetcode.part1;

import commons.ListNode;

/* Given a digit string, return all possible letter combinations that 
 * the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * */

public class T24SwapNodesInPair {

	public static void main(String[] args) {
		int n = 300000;
		ListNode head1=grLinkedList(n);
		long t1=System.currentTimeMillis();
		swapPairs(head1);
		long t2=System.currentTimeMillis();
		System.out.println("function1 cost: "+(t2-t1));
//		System.out.println("result: \n"+head1);
		
		System.out.println("********************");
		ListNode head2=grLinkedList(n);
		long t3=System.currentTimeMillis();
		swapPairs1(head2);
		long t4=System.currentTimeMillis();
		System.out.println("function1 cost: "+(t4-t3));
//		System.out.println("result: \n"+head2);
		

	}
	
	public static ListNode grLinkedList(int n){
		ListNode head = new ListNode(0);
		ListNode tmp = head;
		for (int i = 1; i <= n; i++) {
			tmp.next = new ListNode(i);
			tmp = tmp.next;
		}
		return head;
	}

	// 暴力解法
	public static ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode tmp = dummy;
		while (head != null && head.next != null) {
			ListNode tail = head.next;
			tmp.next = tail;
			head.next = tail.next;
			tail.next = head;
			tmp = head;
			head = head.next;
		}
		return dummy.next;
	}

	// 递归版本
	public static ListNode swapPairs1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode nextNode = head.next;
		nextNode.next = swapPairs1(nextNode.next);
		head.next = nextNode.next;
		nextNode.next = head;
		return nextNode;
	}

}
