package alg.leetcode.part2;

import java.util.Stack;

public class T232ImplementQueueUsingStacks {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek());
		queue.pop();
		System.out.println(queue.peek());
	}

	static class MyQueue {
		private Stack<Integer> pushStack = new Stack<>();
		private Stack<Integer> popStack = new Stack<>();

		// Push element x to the back of queue.
		public void push(int x) {
			pushStack.push(x);
		}

		// Removes the element from in front of queue.
		public void pop() {
			if (popStack.isEmpty()) {
				while (!pushStack.isEmpty()) {
					popStack.push(pushStack.pop());
				}
			}
			popStack.pop();
		}

		// Get the front element.
		public int peek() {
			if (popStack.isEmpty()) {
				while (!pushStack.isEmpty()) {
					popStack.push(pushStack.pop());
				}
			}
			return popStack.peek();
		}

		// Return whether the queue is empty.
		public boolean empty() {
			return pushStack.isEmpty() && popStack.isEmpty();
		}
	}
}
