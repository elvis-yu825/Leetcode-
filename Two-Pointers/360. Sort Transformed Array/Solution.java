class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        int low = 0, high = nums.length-1;
        int i = a> 0 ? nums.length-1 : 0;
        while (low <=high) {
            int lowR = calculate(nums,low,a,b,c);
            int highR = calculate(nums,high,a,b,c);
            if (a>0) {
                if (lowR>=highR) {
                    result[i] = lowR;
                    i--;
                    low++;
                } else {
                    result[i] = highR;
                    i--;
                    high--;
                }
                
            } else {
                if (lowR<= highR) {
                    result[i] = lowR;
                    low++;
                    i++;
                } else {
                    result[i] = highR;
                    i++;
                    high--;
                }
                
            }
        }
        return result;
        
    }
    private static int calculate(int[] nums, int i, int a, int b,int c) {
        return a * nums[i] * nums[i] + b * nums[i] + c;
    }
}
