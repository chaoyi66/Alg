package alg.leetcode.part1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class T10Test

{
    private boolean expected;
    private String value1;
    private String value2;

    @Parameters
    public static Collection<Object[]> getTestParameters() {

	return Arrays.asList(new Object[][] { { false, "a", "ab" }, { true, "ab", "ab" }, { false, "ab", "ac" },
		{ true, "ab", "a." } });
    }

    public T10Test(boolean expected, String value1, String value2) {
	super();
	this.expected = expected;
	this.value1 = value1;
	this.value2 = value2;

    }

    @Test
    public void testLengthOfLongestSubstring() {
	boolean exp = expected;
	boolean result = T10RegularExpressionMatching.isMatchNoStar(value1, value2);
	assertEquals(exp, result);
    }
}
