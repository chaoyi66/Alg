package leetcode.part1;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class T31Test

{
	private int[] expected;
	private int[] v1;

	@Parameters
	public static Collection<Object[]> getTestParameters() {

		return Arrays.asList(new Object[][] { { new int[] { 1, 3, 2 }, new int[] { 1, 2, 3 } },
				{ new int[] { 1, 2 }, new int[] { 2, 1 } },
				{ new int[] { 5, 1, 1 }, new int[] { 1, 5, 1 } },
				{ new int[] { 1, 1 }, new int[] { 1, 1 } } });
	}

	public T31Test(int[] expected, int[] v1) {
		super();
		this.expected = expected;
		this.v1 = v1;
	}

	@Test
	public void test() {
		int[] exp = expected;
		T31NextPermutation.nextPermutation(v1);
		// assertEquals(exp, v1);
		assertTrue(Arrays.equals(exp, v1));
	}
}
