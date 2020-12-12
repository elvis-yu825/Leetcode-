class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> output = new LinkedList<int[]>();
        int i=0;
        //skip (and add to output) all intervals that end before newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            output.add(intervals[i++]);
        }
        //Merge all intervals that overlap with Newinterval
        while (i<intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        //insert new interval
        output.add(newInterval);
        //insert all remaining intervals
        while (i < intervals.length) {
            output.add(intervals[i++]);
        }
        return output.toArray(new int[output.size()][2]);
        
    }
}
