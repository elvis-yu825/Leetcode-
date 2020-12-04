class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int high = n-1;
        int left = 0;
        int right = n-1;
        
        while (left <=right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[high--] = leftSquare;
                left++;
            } else {
                result[high--] = rightSquare;
                right--;
            }
            
        }
        
        return result;
        
    }
}
