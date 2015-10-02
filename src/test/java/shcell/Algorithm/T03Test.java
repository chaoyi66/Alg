package shcell.Algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class T03Test

{
	private Integer expected;
	private String valueOne;

	@Parameters
	public static Collection<Object[]> getTestParameters() {

		return Arrays.asList(new Object[][] { { 0, "" }, { 1, "a" }, { 2, "ab" }, { 2, "aba" }, { 4, "aabcdb" },
				{ 5, "ababcdea" } });
	}

	public T03Test(Integer expected, String valueOne) {
		super();
		this.expected = expected;
		this.valueOne = valueOne;
	}

	@Test
	public void testLengthOfLongestSubstring() {
		int len = expected;
		int result = T03LonggestSubstring.lengthOfLongestSubstring(valueOne);
		assertEquals(len, result);
	}
}
