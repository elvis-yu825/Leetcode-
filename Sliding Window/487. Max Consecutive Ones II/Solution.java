class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int max = 0;
        int result = 0;
        
        for (int end=0; end<nums.length; end++) {
            if (nums[end] == 1) {
                max++;
            } 
            if (end-start+1 - max > 1) {
                if (nums[start] == 1) {
                    max--;
                }
                start++;
            }
            result = Math.max(result,end-start+1);
        }
        
        return result;
        
    }
}
