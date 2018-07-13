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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        
        // make suer start is ascending
        Collections.sort(intervals, (i1, i2) -> {return i1.start - i2.start;});
        
        List<Interval> ans = new ArrayList<>();
        
        int preStart = intervals.get(0).start;
        int preEnd = intervals.get(0).end;
        
        for (int i = 1; i < intervals.size(); i++) {
            int curStart = intervals.get(i).start;
            int curEnd = intervals.get(i).end;
            
            // not overlapping
            if (curStart > preEnd) {
                ans.add(new Interval(preStart, preEnd));
                preStart = curStart;
                preEnd = curEnd;
            }
            // overlapping
            else {
                // preStart = Math.min(preStart, curStart);
                preEnd = Math.max(preEnd, curEnd);
            }
        }
        
        // last one
        ans.add(new Interval(preStart, preEnd));
        
     
        return ans;
    }
}