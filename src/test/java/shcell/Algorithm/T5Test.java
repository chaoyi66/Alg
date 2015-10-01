package shcell.Algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class T5Test

{
	private String expected;
	private String value1;
	private int value2;

	@Parameters
	public static Collection<Object[]> getTestParameters() {

		return Arrays.asList(new Object[][] { { "a", "abcdef", 0 }, { "b", "abcdef", 1 },
				{ "bcb", "abcbef", 2 }, { "cc", "cc", 0 }, { "aa", "aabcdb", 0 },
				{ "abcba", "eabcba", 3 }, { "bb", "abb", 1 } });
	}

	public T5Test(String expected, String value1, int value2) {
		super();
		this.expected = expected;
		this.value1 = value1;
		this.value2 = value2;
	}

	@Test
	public void testLengthOfLongestSubstring() {
		String exp = expected;
		String result = T5LongestPalindromicSubstring.getPalindrome(value1, value2);
		assertEquals(exp, result);
	}
}
