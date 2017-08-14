package alg.leetcode.part1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class T04Test

{
	private double expected;
	private double[] value1;
	private double[] value2;

	@Parameters
	public static Collection<Object[]> getTestParameters() {

		return Arrays.asList(new Object[][] { { 3, new double[] { 1, 2 }, new double[] { 3, 4, 5 } },
				{ 3, new double[] { 1, 2, 3 }, new double[] { 3, 4, 5 } },
				{ 2.5, new double[0] , new double[] { 2,3 } } });
	}

	public T04Test(double expected, double[] value1, double[] value2) {
		super();
		this.expected = expected;
		this.value1 = value1;
		this.value2 = value2;
	}

	@Test
	public void testLengthOfLongestSubstring() {
		double len = expected;
		double result = T04MedianOfTwoSortedArrays.findMedianSortedArrays(value1, value2);
		assertEquals("not equal", len, result, 1e-5);

	}
}
