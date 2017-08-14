package leetcode.part1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class T14Test

{
	private String expected;
	private String[] value1;

	@Parameters
	public static Collection<Object[]> getTestParameters() {

		return Arrays.asList(new Object[][] { { "a", new String[] { "a", "ab" } },
				{ "a", new String[] { "aa", "a" } } });
	}

	public T14Test(String expected, String[] value1) {
		super();
		this.expected = expected;
		this.value1 = value1;
	}

	@Test
	public void testLengthOfLongestSubstring() {
		String exp = expected;
		String result = T14LonggestCommonPrefix.longestCommonPrefix(value1);
		assertEquals(exp, result);
	}
}
