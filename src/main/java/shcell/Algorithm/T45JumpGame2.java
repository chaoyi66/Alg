package shcell.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class T45JumpGame2 {

	public static void main(String[] args) {
		// int[] height = new int[] { 5, 8, 1, 8, 9, 8, 7, 1, 7, 5, 8, 6, 5, 4,
		// 7, 3, 9, 9, 0, 6, 6, 3,
		// 4, 8, 0, 5, 8, 9, 5, 3, 7, 2, 1, 8, 2, 3, 8, 9, 4, 7, 6, 2, 5, 2, 8,
		// 2, 7, 9, 3, 7,
		// 6, 9, 2, 0, 8, 2, 7, 8, 4, 4, 1, 1, 6, 4, 1, 0, 7, 2, 0, 3, 9, 8, 7,
		// 7, 0, 6, 9, 9,
		// 7, 3, 6, 3, 4, 8, 6, 4, 3, 3, 2, 7, 8, 5, 8, 6, 0 };
		int[] height = new int[] { 2, 0, 0, 0 };
		T45JumpGame2 o = new T45JumpGame2();
		System.out.println(o.jump2(height));
	}

	private int[] nums;
	private int[] jumpMin;
	private int len;
	private List<Integer> path;
	private TreeMap<Integer, List<Integer>> paths;

	public int jump1(int[] nums) {
		this.nums = nums;
		this.len = nums.length;
		this.path = new ArrayList<>();
		this.paths = new TreeMap<>();
		paths.put(Integer.MAX_VALUE, null);
		jumpMin = new int[len];
		Arrays.fill(jumpMin, Integer.MAX_VALUE);
		long t1 = System.currentTimeMillis();
		jumpNext(0, 0);
		long t2 = System.currentTimeMillis();
		System.out.println("Time cost: " + (t2 - t1));
		return paths.firstKey();
	}

	private void jumpNext(int index, int jumpCount) {
		if (index >= len)
			return;

		if (index == len - 1) {
			paths.put(jumpCount, new ArrayList<>(path));
			return;
		}

		if (jumpCount > jumpMin[index] || jumpCount >= paths.firstKey())
			return;
		else
			jumpMin[index] = jumpCount;

		for (int i = nums[index]; i > 0; i--) {
			int next = index + i;
			jumpCount++;
			path.add(next);
			jumpNext(next, jumpCount);
			path.remove(path.size() - 1);
			jumpCount--;
		}
	}

	// 没有考虑到不了目标的情况，比如{2,0,0,0}
	public int jump(int[] nums) {
		if (nums.length < 2)
			return 0;
		int cur = 0;
		int count = 0;
		int max = 0;
		while (cur < nums.length && cur + nums[cur] < nums.length - 1) {
			count++;

			int next = 0;
			for (int i = 1; i <= nums[cur]; i++) {
				if (cur + i + nums[cur + i] > max) {
					next = cur + i;
					max = cur + i + nums[cur + i];
				}
			}
			cur = next;
		}
		return count + 1;

	}

	public int jump2(int[] nums) {
		int dp = 0;
		int r = 0, max = 0;
		for (int i = 0; max < nums.length - 1; i++) {
			// can break as soom as possible
			if (max == i && nums[i] == 0)
				return -1;
			max = Math.max(max, i + nums[i]);
			if (r == i) {
				dp++;
				r = max;
			}
		}
		return (max == r) ? dp : dp + 1;
	}
}
