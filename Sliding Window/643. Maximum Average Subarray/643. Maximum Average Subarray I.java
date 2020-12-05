class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int sum = 0;
        double average = 0;
        double result = Integer.MIN_VALUE;
        
        for (int end=0; end<nums.length; end++) {
            sum += nums[end]; // add next number
            // slide the window after hit the window size "k"
            if (end >= k-1) {
                average = (double)sum / k;
                if (average > result) {
                    result = average;
                }
                sum -= nums[start]; // delete the number going out
                start++; // slide the window ahead
            }
        }
        
        return result;
        
        
    }
}