class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length<=0) return result;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0; i < nums.length; i++) {
            int wanted = target - nums[i];
            if (map.containsKey(wanted)) {
                result[0] = i;
                result[1] = map.get(wanted);
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
        
    }
}
