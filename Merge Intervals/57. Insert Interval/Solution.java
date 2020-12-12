class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, length = intervals.length;
        LinkedList<int[]> output = new LinkedList<int[]>();
        
        while (idx < length && intervals[idx][0] < newStart) {
            output.add(intervals[idx++]);
        }
        
        int[] currentInterval = new int[2];
        if (output.isEmpty() || output.getLast()[1] < newStart) {
            output.add(newInterval);
        } else {
            currentInterval = output.removeLast();
            currentInterval[1] = Math.max(currentInterval[1], newEnd);
            output.add(currentInterval);
        }
        
        while (idx < length) {
            currentInterval = intervals[idx++];
            int start = currentInterval[0], end = currentInterval[1];
            if (output.getLast()[1] < start) {
                output.add(currentInterval);
            } else {
                currentInterval = output.removeLast();
                currentInterval[1] = Math.max(currentInterval[1],end);
                output.add(currentInterval);
            }
        }
        return output.toArray(new int[output.size()][2]);
        
    }
}
