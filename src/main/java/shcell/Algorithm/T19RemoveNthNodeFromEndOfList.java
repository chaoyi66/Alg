package shcell.Algorithm;

/* Given a digit string, return all possible letter combinations that 
 * the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be 
in any order you want.
*/

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		// 递归打印链表
		if (this.next != null)
			return "*->" + val + "\n" + this.next.toString();
		else
			return "*->" + val + "\n";
	}
}

public class T19RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		// System.out.println(letterCombinations1("232"));
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		// ListNode n3 = new ListNode(3);
		head.next = n2;
		// n2.next = n3;
		ListNode ln = removeNthFromEnd(head, 2);
		System.out.println(ln);
	}

	// 双指针解法
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode front = head;
		ListNode back = head;
		ListNode backPre = head;

		int i = 0;
		do {
			front = front.next;
			i++;
			if (i >= n + 1) {
				backPre = back;
				back = back.next;
			}
		} while (front != null);
		if (back == head) {
			head = head.next;
		}
		backPre.next = back.next;
		return head;
	}

	// 双指针解法,加上一个伪链表头，此时将head节点变成普通节点
	public static ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		// slow停止时指向的是待删除节点的prev，也因此fast需要提前走N+1步
		for (int i = 1; i <= n + 1; i++)
			fast = fast.next;
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}

}
