/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int cur=0;
        while( cur< intervals.size() && newInterval.start> intervals.get(cur).start) cur++;
        if(cur==0 || intervals.get(cur-1).end<newInterval.start) intervals.add(cur, newInterval);
        else {
            if(intervals.get(cur-1).end < newInterval.end) intervals.get(cur-1).end= newInterval.end;
            cur--;
        }
        while(cur < intervals.size()-1 && intervals.get(cur).end>=intervals.get(cur+1).start){
            if(intervals.get(cur).end<intervals.get(cur+1).end)intervals.get(cur).end=intervals.get(cur+1).end;
            intervals.remove(cur+1);
        }
        return intervals;
    }
}
