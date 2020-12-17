class Solution {
    public int maxSubArray(int[] nums) {
        int maxToCur = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxToCur = Math.max(maxToCur + nums[i], nums[i]);
            sum = Math.max(sum, maxToCur);
        }
        
        return sum;
        
    }
}

//The basic idea of Kadane’s algorithm is to scan the entire array and at each position find the maximum sum of the subarray ending there.
