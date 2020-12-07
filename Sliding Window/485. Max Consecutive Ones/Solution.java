class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int result =0;
        for (int end=0; end< nums.length; end++) {
            if (nums[end] == 1) {
                max++;
            }
            result = Math.max(result,max);
            
            if (nums[end] == 0) {
                max = 0;
            }
        }
        return result;
        
    }
}
