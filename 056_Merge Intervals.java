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
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }
        });
        List<Interval> res= new ArrayList<Interval>(intervals.size()/4);
        for(Interval i: intervals){
            if(res.size()==0) res.add(i);
            else{
                Interval last=res.get(res.size()-1);
                if(last.end>=i.start){
                    if(last.end<i.end) last.end=i.end;
                }
                else res.add(i);
            }
        }
        return res;
    }
}
