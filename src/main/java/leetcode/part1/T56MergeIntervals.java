package leetcode.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import commons.Interval;

public class T56MergeIntervals {

	public static void main(String[] args) {
		Interval iv = new Interval(1, 4);
		Interval iv2 = new Interval(2, 3);

		ArrayList<Interval> list = new ArrayList<>();
		list.add(iv);
		list.add(iv2);
		System.out.println(merge(list));
	}

//	另开一个list存储结果可能更方便点
	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() < 1)
			return intervals;
		Collections.sort(intervals, (x, y) -> {
			return x.start - y.start;
		});
		int index = 0;
		Interval tmp = intervals.get(index);
		Iterator<Interval> iterator = intervals.iterator();
		while (iterator.hasNext()) {
			Interval cur = iterator.next();
			if (cur.start <= tmp.end) {
				tmp.end = Math.max(tmp.end, cur.end);
			} else {
				tmp = intervals.get(++index); // 如果list是LinkedList，可能引起平方的复杂度
				tmp.start = cur.start;
				tmp.end = cur.end;
			}
		}
		return intervals.subList(0, ++index);

	}

}

