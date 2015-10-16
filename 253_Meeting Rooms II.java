/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 class comparestart implements Comparator<Interval>{
     public int compare(Interval interval1, Interval interval2){
         return interval1.start-interval2.start;
     }
 }
 
 class compareEnd implements Comparator<Interval>{
     public int compare(Interval interval1, Interval interval2){
         return interval1.end-interval2.end;
     }
 }
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length==0) return 0;
        Arrays.sort(intervals, new comparestart());
        int result=0;
        PriorityQueue<Interval> hp=new PriorityQueue<Interval>(intervals.length, new compareEnd());
        for(Interval temp: intervals){
            while(hp.peek()!=null && hp.peek().end<=temp.start) hp.poll();
            hp.offer(temp);
            result=Math.max(result,hp.size());
        }
        return result;
    }
}
