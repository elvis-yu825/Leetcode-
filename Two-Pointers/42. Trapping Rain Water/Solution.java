class Solution {
    public int trap(int[] height) {
        if (height == null || height.length<3) return 0;
        int result = 0;
        int start = 0;
        int end = height.length-1; 
        int left = 0;
        int right = 0;
        while (start < end) {
            left = Math.max(left,height[start]);
            right = Math.max(right,height[end]);
            if (left<right) {
                result += left - height[start];
                start++;
            } else {
                result += right - height[end];
                end--;
            }
        }
        return result;
        
        
        
    }
}
