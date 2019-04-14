/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> resInter = new ArrayList<>();
        int size = intervals.size(), it = 0;
        
        // Add all non-overlapping smaller intervals
        while (it < size && intervals.get(it).end < newInterval.start) {
            resInter.add(intervals.get(it));
            it++;
        }
        int newStart = newInterval.start;
        int newEnd = newInterval.end;        
        
        if (it < size) {
            newStart = Math.min(intervals.get(it).start, newInterval.start);
        }
        
        // Merge Overlapping Intervals
        while (it < size && intervals.get(it).start <= newInterval.end) {
            newEnd = Math.max(intervals.get(it).end, newEnd);
            it++;
        }
        
        resInter.add(new Interval(newStart, newEnd));
        
        while (it < size) {
            resInter.add(intervals.get(it));
            it++;
        }
        
        return resInter;
    }
}