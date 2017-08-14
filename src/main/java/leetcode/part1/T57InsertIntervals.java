package leetcode.part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import commons.Interval;

public class T57InsertIntervals {

	public static void main(String[] args) {
		Interval iv = new Interval(3, 5);
		Interval iv2 = new Interval(12, 15);
		// Interval iv3 = new Interval(7, 12);

		Interval newInterval = new Interval(6, 6);
		ArrayList<Interval> list = new ArrayList<>();
		list.add(iv);
		list.add(iv2);
		System.out.println(insert1(list, newInterval));
	}

	// 另开一个list存储结果可能更方便点
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		// LinkedList<Interval> linkedList = (LinkedList<Interval>) intervals;
		int index = 0;
		Iterator<Interval> itor = intervals.iterator();
		while (itor.hasNext()) {
			if (itor.next().start >= newInterval.start) {
				break;
			} else
				index++;
		}
		intervals.add(index, newInterval);
		return T56MergeIntervals.merge(intervals);

	}

	public static List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new LinkedList<>();
		int i = 0;
		// add all the intervals ending before newInterval starts
		while (i < intervals.size() && intervals.get(i).end < newInterval.start)
			result.add(intervals.get(i++));
		// merge all overlapping intervals to one considering newInterval
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			i++;
		}
		result.add(newInterval); // add the union of intervals we got
		// add all the rest
		while (i < intervals.size())
			result.add(intervals.get(i++));
		return result;

	}

	public List<Interval> insert3(List<Interval> intervals, Interval newInterval) {
		if (intervals.isEmpty()) {
			intervals.add(newInterval);
		}
		ListIterator<Interval> iter = intervals.listIterator();
		boolean started = false;
		while (iter.hasNext()) {
			Interval curInterval = iter.next();
			if (!started) {
				if (overlap(newInterval, curInterval) || overlap(curInterval, newInterval)) {
					started = true;
					curInterval.start = Math.min(curInterval.start, newInterval.start);
					curInterval.end = Math.max(curInterval.end, newInterval.end);
				} else if (curInterval.start > newInterval.end) {
					iter.previous();
					iter.add(newInterval);
					iter.next();
					started = true;
				}
			} else if (started) {
				if (curInterval.start > newInterval.end) {
					break;
				} else {
					iter.remove();
					iter.previous();
					iter.next().end = Math.max(curInterval.end, newInterval.end);
				}
			}
		}
		if (!started) {
			intervals.add(newInterval);
		}
		return intervals;
	}

	public boolean overlap(Interval v1, Interval v2) {
		if ((v1.start >= v2.start && v1.start <= v2.end)
				|| (v1.end >= v2.start && v1.end <= v2.end)) {
			return true;
		}
		return false;
	}
}
