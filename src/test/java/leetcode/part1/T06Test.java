package leetcode.part1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class T06Test

{
	private String expected;
	private String value1;
	private int value2;

	@Parameters
	public static Collection<Object[]> getTestParameters() {

		return Arrays.asList(new Object[][] {  { "ABDC","ABCD", 3 } });
	}

	public T06Test(String expected, String value1, int value2) {
		super();
		this.expected = expected;
		this.value1 = value1;
		this.value2 = value2;
	}

	@Test
	public void testLengthOfLongestSubstring() {
		String exp = expected;
		String result = T06ZigZagConversion.convert(value1, value2);
		assertEquals(exp, result);
	}
}
