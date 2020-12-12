class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //initiate data
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, length = intervals.length;
        LinkedList<int[]> output = new LinkedList<int[]>();
        //add all intervals starting before newInterval
        while (idx < length && intervals[idx][0] < newStart) {
            output.add(intervals[idx++]);
        }
        //add new interval
        int[] currentInterval = new int[2];
        //check if there is overlap with the last interval starting before newInterval
        if (output.isEmpty() || output.getLast()[1] < newStart) {
            output.add(newInterval);//add interval if no overlap
        } else {
            currentInterval = output.removeLast();
            currentInterval[1] = Math.max(currentInterval[1], newEnd);
            output.add(currentInterval);//remove the last interval with its start and reset the end
        }
        //continue add following intervals,merge with previous interval if overlap
        while (idx < length) {
            currentInterval = intervals[idx++];
            int start = currentInterval[0], end = currentInterval[1];
            if (output.getLast()[1] < start) {
                output.add(currentInterval);
            } else {
                currentInterval = output.removeLast();
                currentInterval[1] = Math.max(currentInterval[1],end);
                output.add(currentInterval);//remove the last interval, use its start and reset the end
            }
        }
        return output.toArray(new int[output.size()][2]);
        
    }
}
