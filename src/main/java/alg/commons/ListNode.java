package alg.commons;

public class ListNode implements Comparable<ListNode> {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		// 递归打印链表
		if (this.next != null)
			return "->" + val + "*\t" + this.next.toString();
		else
			return "->" + val + "*\t";
	}

	@Override
	public int compareTo(ListNode o) {
		return this.val - o.val;
	}
}
