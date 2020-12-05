class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length<3) {
            return 0;
        }
        
        int count =0;
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-2; i++) {
            count += searchPair(nums, target-nums[i], i);
        }
        return count;
        
    }
    public static int searchPair(int[] nums, int targetSum, int first) {
        int left = first+1;
        int right = nums.length-1;
        int count =0;
        while (left<right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum < targetSum) {
                count += right-left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
    
}
