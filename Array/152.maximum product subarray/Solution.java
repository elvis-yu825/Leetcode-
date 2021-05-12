class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int maxnow = nums[0];
        int minnow = nums[0];
        int result = maxnow;
        
        for (int i=1; i<nums.length; i++) {
            int cur = nums[i];
            int tempmax = Math.max(cur,Math.max(maxnow*cur,minnow*cur));
            minnow = Math.min(cur,Math.min(minnow*cur,maxnow*cur));
            maxnow = tempmax;
            result = Math.max(maxnow,result);
        }
        return result;
    }
}
