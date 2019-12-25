package leetcode;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        intervals = merge(intervals);
        System.out.println("");
    }
    
    private static class Interval {
        final int start;
        final int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static int[][] merge(int[][] intervals) {
        List<Interval> intervalList = toIntervalList(intervals);
        Collections.sort(intervalList, (i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> mergedIntervals = new ArrayList<>();
        
        for (Interval interval : intervalList) {
            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(interval);
                continue;
            }
            
            Interval lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            if (lastInterval.end >= interval.start) {
                Interval newInterval = new Interval(lastInterval.start, Integer.max(lastInterval.end, interval.end));
                mergedIntervals.remove(mergedIntervals.size() - 1);
                mergedIntervals.add(newInterval);
            } else {
                mergedIntervals.add(interval);
            }
        }
        
        return toIntervalArray(mergedIntervals);
        
    }
    
    private static List<Interval> toIntervalList(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }
        
        return intervalList;
    }
    
    private static int[][] toIntervalArray(List<Interval> intervals) {
        int[][] intervalArray = new int[intervals.size()][];
        for (int i = 0; i < intervals.size(); i++) {
            int[] newInterval = new int[2];
            newInterval[0] = intervals.get(i).start;
            newInterval[1] = intervals.get(i).end;
            intervalArray[i] = newInterval;
        }
        
        return intervalArray;
    }
}
