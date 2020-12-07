class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer,Integer> map = new HashMap<>();
        int start =0;
        int max = 0;
        
        for (int end=0; end<tree.length; end++) {
            int right = tree[end];
            map.put(right,map.getOrDefault(right,0) +1); // add element into the map
            // shrink the window until we only have two type of fruits in the basket
            while (map.size() > 2) {
                int left = tree[start];
                map.put(left, map.get(left) -1);
                if (map.get(left) == 0) {
                    map.remove(left);
                
                }
                start++; //shrink the window
            }
            max = Math.max(max, end-start +1);
        }
        return max;
        
    }
}
