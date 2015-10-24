package test;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class TestPredicate {

	public static void main(String[] args) {
		int n = 10;
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i;
		}
		List<Integer> list = Arrays.asList(ArrayUtils.toObject(nums));
		System.out.println(list);
		list.stream().filter(x -> {
			return x > 5;
		}).forEach(x -> System.out.println(x));
		;
//		System.out.println(list);

	}

}
