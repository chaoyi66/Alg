package shcell.commons;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		// 递归打印链表
		if (this.next != null)
			return "->" + val + "*\t" + this.next.toString();
		else
			return "->" + val + "*\t";
	}
}
