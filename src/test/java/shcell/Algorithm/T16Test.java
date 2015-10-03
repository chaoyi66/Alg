package shcell.Algorithm;

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
public class T16Test

{
	private int expected;
	private int[] v1;
	private int v2;

	@Parameters
	public static Collection<Object[]> getTestParameters() {

		return Arrays.asList(new Object[][] { { 2, new int[] { -1, 2, 1, -4 }, 1 }, });
	}

	public T16Test(int expected, int[] v1, int v2) {
		super();
		this.expected = expected;
		this.v1 = v1;
		this.v2 = v2;
	}

	@Test
	public void test() {
		int exp = expected;
		int result = T16ThreeSumClosest.threeSumClosest(v1, v2);
		assertEquals(exp, result);
	}
}
