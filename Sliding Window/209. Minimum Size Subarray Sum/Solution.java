class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        
        for (int end=0;end<nums.length; end++) {
            sum += nums[end];
            
            while (sum >= s) {
                min = Math.min(min, end-start+1);
                sum -= nums[start];
                start++;
            }
        }
        
        return min == Integer.MAX_VALUE ? 0:min;
        
    }
}
