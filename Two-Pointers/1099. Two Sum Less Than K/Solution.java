class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        int result = -1;
        while (low < high) {
            int sum = nums[low] + nums[high]; 
            //if sum<k, we move lower up to move sum closer to the target
            if (sum < k) {
                result = Math.max(result,sum);
                low++;
            } else {
            //if sum>k, we move high down to maintain a sum<k
                high--;
            }
            
        }
        return result;
        
        
    }
}
