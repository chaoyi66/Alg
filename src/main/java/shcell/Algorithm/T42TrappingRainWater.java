package shcell.Algorithm;

import java.util.PriorityQueue;

public class T42TrappingRainWater {

	public static void main(String[] args) {
		int[] height = new int[] { 0, 2, 0 };
		System.out.println(trap(height));
	}

	public static int trap(int[] height) {

		int left = 0, right = height.length - 1;

		int level = 0, result = 0;

		while (left < right) {

			level = Math.max(Math.min(height[left], height[right]), level);

			if (height[left] <= height[right]) {
				result += level - height[left];
				left++;
			} else {
				result += level - height[right];
				right--;
			}
		}

		return result;

	}

	public static int trap1(int[] height) {
		if (height.length < 3)
			return 0;

		int ans = 0;
		int l = 0, r = height.length - 1;

		// find the left and right edge which can hold water
		while (l < r && height[l] <= height[l + 1])
			l++;
		while (l < r && height[r] <= height[r - 1])
			r--;

		while (l < r) {
			int left = height[l];
			int right = height[r];
			if (left <= right) {
				// add volum until an edge larger than the left edge
				while (l < r && left >= height[++l]) {
					ans += left - height[l];
				}
			} else {
				// add volum until an edge larger than the right volum
				while (l < r && height[--r] <= right) {
					ans += right - height[r];
				}
			}
		}
		return ans;
	}

	public static int trap2(int[] height) {
		// 找出最大值的位置
		int maxHeight = 0, maxPosition = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > maxHeight) {
				maxHeight = height[i];
				maxPosition = i;
			}
		}
		int[] h = new int[height.length];
		int maxLeft = 0;
		for (int i = 1; i <= maxPosition; i++) {
			if (height[i - 1] > maxLeft)
				maxLeft = height[i - 1];
			h[i] = maxLeft;
		}
		int maxRight = 0;
		for (int i = height.length - 2; i >= maxPosition; i--) {
			if (height[i + 1] > maxRight)
				maxRight = height[i + 1];
			h[i] = maxRight;
		}
		int water = 0;
		for (int i = 0; i < h.length; i++) {
			if (h[i] > height[i])
				water += h[i] - height[i];
		}
		return water;

	}

	public static int trap3(int[] height) {
		if (height.length < 2)
			return 0;
		// 建堆
		PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> {
			return -(x.height - y.height); // 因为优先队列是从小到大，所以这里要取最大值，则比较器应该相反
		});
		for (int i = 0; i < height.length; i++) {
			pq.add(new Pair(i, height[i]));
		}
		// 初始化两端
		Pair p1 = pq.poll();
		Pair p2 = pq.poll();
		int start = Math.min(p1.position, p2.position);
		int end = Math.max(p1.position, p2.position);
		int water = p2.height * (end - start - 1);
		// 如果新添加的条在已知容器内部，则减去该条的面积。在外部则加上新的water
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			int p = pair.position;
			int h = pair.height;
			if (p < end && p > start) {
				water -= h;
			} else {
				if (p >= end) {
					water += (p - end - 1) * h;
					end = p;
				} else {
					water += (start - p - 1) * h;
					start = p;
				}
			}
		}
		return water;
	}

	static class Pair {
		public int position;
		public int height;

		public Pair(int position, int height) {
			this.position = position;
			this.height = height;
		}

	}
}
