class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int low = 0, high=nums.length-1;
        // find the first number out of sorting order from the beginning
        while (low < nums.length-1 && nums[low] <= nums[low+1]) {
            low++;
        }
        //if the array is sorted
        if (low == nums.length-1) {
            return 0;
        }
        //find the first number out of sorting order from the end
        while (high>0 && nums[high] >= nums[high-1]) {
            high--;
        }
        
        //find the minimum and maximum of the subarray
        int subarrayMax = Integer.MIN_VALUE, subarrayMin = Integer.MAX_VALUE;
        for (int k=low; k <= high; k++) {
            subarrayMax = Math.max(subarrayMax, nums[k]);
            subarrayMin = Math.min(subarrayMin, nums[k]);
        }
        //extend the subarray to inlcude any number which is bigger than the minimum of the subarray
        while (low > 0 && nums[low-1] > subarrayMin) {
            low--;
        }
        //extend the subarray to include any number which is smaller than the maximum of the subarray
        while (high < nums.length-1 && nums[high+1] < subarrayMax) {
            high++;
        }
        
        return high-low+1;
        
        
        
    }
}
