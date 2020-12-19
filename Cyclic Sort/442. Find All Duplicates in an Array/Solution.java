class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i=0;
        while (i<nums.length) {
            if (nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for (int j=0; j< nums.length; j++) {
            if (nums[j] != j+1) {
                result.add(nums[j]);
            }
        }
        return result;
        
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
