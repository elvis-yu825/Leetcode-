class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            boolean isForward = nums[i] > 0; // if we are moving forward or not
            int slow = i, fast = i;
            
            //if slow or fast equals "-1", means we cant find cycle for this number
            do {
                slow = findNextIndex(nums, isForward, slow);// move one step for slow pointer
                fast = findNextIndex(nums, isForward, fast);// move one step for fast pointer
                if (fast != -1) {
                    fast = findNextIndex(nums, isForward, fast);// move another step for fast pointer
                }
            } while (
                slow != -1 && fast != -1 && slow != fast
            );
            if (slow != -1 && slow == fast) {
                return true;
            }
            
        }
        return false;
        
    }
    
    public static int findNextIndex(int[] nums, boolean isForward, int currentIndex) {
        boolean direction = nums[currentIndex] > 0;
        if (isForward != direction) {
            return -1; // different direction, return -1; proceed next item;
        }
        int nextIndex = (currentIndex + nums[currentIndex]) % nums.length;
        if (nextIndex < 0) {
            nextIndex += nums.length; // wrap around for negative numbers
        }
        if (nextIndex == currentIndex) {
            return -1;//one element cyle, return -1;
        }
        return nextIndex;
    }
}
