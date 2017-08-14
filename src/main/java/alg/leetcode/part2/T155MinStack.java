package alg.leetcode.part2;

import java.util.Stack;

public class T155MinStack {

	public static void main(String[] args) {
		System.out.println();
		T155MinStack minStack = new T155MinStack();
		minStack.push(2);
		minStack.push(0);
		minStack.push(3);
		minStack.push(0);
		System.out.println(minStack.getMin());
		System.out.println(minStack.pop());
		System.out.println(minStack.getMin());
		System.out.println(minStack.pop());
		System.out.println(minStack.getMin());
		System.out.println(minStack.pop());
		System.out.println(minStack.getMin());

	}

	private Stack<Integer> stack = new Stack<>();
	private int dif = 0;

	public void push(int x) {

		if (stack.isEmpty())
			dif = 0;
		else if (dif < 0) {
			dif = x - stack.peek();
		} else {
			dif = x - (stack.peek() - dif);
		}
		stack.push(x);
	}

	public int pop() {
		try {
			int tmp = stack.pop();
			if (!stack.isEmpty())
				dif = stack.peek() - (tmp - dif);
			return tmp;
		} catch (Exception e) {
			throw e;
		}

	}

	public int top() {
		return stack.peek();

	}

	public int getMin() {
		return dif > 0 ? (stack.peek() - dif) : stack.peek();

	}
	
//	简洁算法
//	long min;
//    Stack<Long> stack;
//
//    public MinStack(){
//        stack=new Stack<>();
//    }
//
//    public void push(int x) {
//        if (stack.isEmpty()){
//            stack.push(0L);
//            min=x;
//        }else{
//            stack.push(x-min);//Could be negative if min value needs to change
//            if (x<min) min=x;
//        }
//    }
//
//    public void pop() {
//        if (stack.isEmpty()) return;
//
//        long pop=stack.pop();
//
//        if (pop<0)  min=min-pop;//If negative, increase the min value
//
//    }
//
//    public int top() {
//        long top=stack.peek();
//        if (top>0){
//            return (int)(top+min);
//        }else{
//           return (int)(min);
//        }
//    }
//
//    public int getMin() {
//        return (int)min;
//    }
}
