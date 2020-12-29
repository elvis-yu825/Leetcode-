class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int item : nums1) {
            set.add(item);
        }
        for (int item: nums2) {
            if (set.contains(item)) {
                result.add(item);
            }
        }
        int[] output = new int[result.size()];
        int i=0;
        for (int item : result) {
            output[i++] = item;
        }
        return output;
    }
}
