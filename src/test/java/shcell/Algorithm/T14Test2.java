package shcell.Algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class T14Test2

{
	private String expected;
	private String value1;
	private String value2;

	@Parameters
	public static Collection<Object[]> getTestParameters() {

		return Arrays.asList(new Object[][] { { "a", "a", "ab" } , { "a", "aa", "ab" } });
	}

	public T14Test2(String expected, String value1, String value2) {
		super();
		this.expected = expected;
		this.value1 = value1;
		this.value2 = value2;

	}

	@Test
	public void testLengthOfLongestSubstring() {
		String exp = expected;
		String result = T14LonggestCommonPrefix.getCommonPrefix(value1, value2);
		assertEquals(exp, result);
	}
}
