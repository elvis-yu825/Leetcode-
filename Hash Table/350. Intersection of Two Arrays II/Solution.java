class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int item : nums1) {
            map.put(item, map.getOrDefault(item,0) + 1);
        }
        for (int item : nums2) {
            if (map.containsKey(item)) {
                
                if (map.get(item) == 0) {
                    map.remove(item);
                } else {
                    result.add(item);
                    map.put(item,map.get(item)-1);
                }
                
            }
        }
        int[] output = new int[result.size()];
        int i=0;
        for (int item:result) {
            output[i++] = item;
        }
        return output;
        
        
    }
}
