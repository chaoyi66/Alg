package alg.leetcode.part1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class T15Test

{
	private List<List<Integer>> expected;
	private int[] value1;

	@Parameters
	public static Collection<Object[]> getTestParameters() {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		List<Integer> tmpList = Arrays.asList(0, 0, 0);
		list.add(tmpList);
		return Arrays.asList(new Object[][] { { list, new int[] { 0, 0, 0 } },
				{ list, new int[] { 0, 0, 0, 0 } } });
	}

	public T15Test(List<List<Integer>> expected, int[] value1) {
		super();
		this.expected = expected;
		this.value1 = value1;

	}

	@Test
	public void test() {
		List<List<Integer>> exp = expected;
		List<List<Integer>> result = T15ThreeSum.threeSum(value1);
		assertEquals(exp, result);
	}
}
