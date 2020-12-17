class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int[] output = new int[nums.length];
        //calculate the product on the left side for each element
        for (int i=0; i<nums.length; i++) {
            output[i] = left;
            left *= nums[i];
        }
        
        int right = 1;
        // multiply the product of left side with the product of right side
        for (int i=nums.length-1; i>=0; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        
        return output;
        
    }
}
