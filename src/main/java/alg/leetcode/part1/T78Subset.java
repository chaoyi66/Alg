package alg.leetcode.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class T78Subset {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };

		System.out.println(subsets(nums));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		Integer[] newNums = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			newNums[i] = nums[i];
		}
		Arrays.sort(newNums, (x, y) -> y - x);

		List<List<Integer>> ans = new LinkedList<>();
		dfs(ans, nums, 0, new LinkedList<>());
		return ans;
	}

	private static void dfs(List<List<Integer>> ans, int[] nums, int index, List<Integer> list) {
		if (index == nums.length) {
			ans.add(new LinkedList<>(list));
			return;
		}
		dfs(ans, nums, index + 1, list);
		list.add(nums[index]);
		dfs(ans, nums, index + 1, list);
		list.remove(list.size() - 1);
	}
	
	public List<List<Integer>> subsets1(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        Arrays.sort(S);
        for(int i : S) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }

	
	public List<List<Integer>> subsets3(int[] nums) {
	    int n = nums.length;
	    List<List<Integer>> subsets = new ArrayList<>();
	    for (int i = 0; i < Math.pow(2, n); i++)
	    {
	        List<Integer> subset = new ArrayList<>();
	        for (int j = 0; j < n; j++)
	        {
	            if (((1 << j) & i) != 0)
	                subset.add(nums[j]);
	        }
	        Collections.sort(subset);
	        subsets.add(subset);
	    }
	    return subsets;
	}
}
