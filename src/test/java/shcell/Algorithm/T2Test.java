package shcell.Algorithm;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;
import shcell.Algorithm.T02AddTwoNumber.ListNode;

@RunWith(value = Parameterized.class)
public class T2Test {
    private ListNode expected;
    private ListNode valueOne;
    private ListNode valueTwo;

    @Parameters
    public static Collection<ListNode[]> getTestParameters() {
	ArrayList<ListNode[]> a = new ArrayList<>();
	

	ListNode exp = new ListNode(0);
	exp.next = new ListNode(1);
	ListNode valueOne = new ListNode(5);
	ListNode valueTwo = new ListNode(5);
	ListNode[] b = new ListNode[]{exp,valueOne,valueTwo};
	a.add(b);
	return a;
    }

    public T2Test(ListNode expected, ListNode valueOne, ListNode valueTwo) {
	this.expected = expected;
	this.valueOne = valueOne;
	this.valueTwo = valueTwo;
    }

    @Test
    public void sum() {
	assertEquals(expected,T02AddTwoNumber.addTwoNumbers(valueOne, valueTwo));
    }
}
