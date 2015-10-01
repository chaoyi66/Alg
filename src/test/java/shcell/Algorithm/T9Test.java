package shcell.Algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class T9Test

{
    private boolean expected;
    private int value1;

    @Parameters
    public static Collection<Object[]> getTestParameters() {

	return Arrays.asList(new Object[][] { { false, 3 }, { false, 34 }, { true, 33 }, { false, 1234 }, { false, 34 },
		{ true, 1221 }, { true, 12321 }, { false, 12341 } });
    }

    public T9Test(boolean expected, int value1) {
	super();
	this.expected = expected;
	this.value1 = value1;
    }

    @Test
    public void testLengthOfLongestSubstring() {
	boolean exp = expected;
	boolean result = T9PalindromeNumber.isPalindrome1(value1);
	assertEquals(exp, result);
    }
}
