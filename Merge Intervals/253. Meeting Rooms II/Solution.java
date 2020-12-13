class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //sort the meeting by start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int minRooms = 0;
        PriorityQueue<int[]> minheap = 
            new PriorityQueue<int[]>(intervals.length, (a,b) -> Integer.compare(a[1],b[1]));
        for (int[] interval : intervals) {
            //remove all meetings that ended before current meeting start
            while (!minheap.isEmpty() && interval[0] >= minheap.peek()[1]) {
                minheap.poll();
            }
            //add the current meeting into the minheap
            minheap.offer(interval);
            //all active meetings are in minheap, each of them need one room
            //compare the number of room needed with prior minrooms
            minRooms = Math.max(minRooms, minheap.size());
        }
        return minRooms;
        
        
    }
}
