class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 1;
        for (int end=1; end< nums.length; end++) {
            if (nums[end] != nums[start-1]) {
                nums[start] = nums[end];
                start++;
            }
        }
        
        return start;
        
        
    }
}
