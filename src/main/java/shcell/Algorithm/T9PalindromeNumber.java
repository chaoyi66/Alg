package shcell.Algorithm;

import java.util.Stack;

/* Determine whether an integer is a palindrome. 
 * Do this without extra space.*/

public class T9PalindromeNumber {

    public static void main(String[] args) {
	System.out.println((-6) % 5);
    }

//    使用了额外的空间，不符合题目要求
    public static boolean isPalindrome1(int x) {
	if (x < 0) {
	    return false;
	}
	String s = new Integer(x).toString();
	int len = s.length();
	Stack<Integer> stack = new Stack<>();
	int i = 1;
	while (i <= len) {
	    if (i <= len / 2) {
		stack.push(x % 10);
	    } else if (i == len / 2 + 1 && len % 2 != 0) {
	    } else {
		if (stack.pop() != x % 10)
		    return false;
	    }
	    x = x / 10;
	    i++;
	}
	return true;
    }

}
