package shcell.Algorithm;

import java.util.PriorityQueue;

public class T42TrappingRainWater {

	public static void main(String[] args) {
		int[] height = new int[] { 0, 2, 0 };
		System.out.println(trap(height));
	}

	public static int trap(int[] height) {
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
