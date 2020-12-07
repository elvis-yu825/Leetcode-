class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        
        for (int end=0; end<s.length(); end++) {
            char right = s.charAt(end);
            if (map.containsKey(right)) {
                start = Math.max(start,map.get(right) +1);
            }
            map.put(right,end);
            max = Math.max(max, end-start+1);
            
        }
        return max;
        
    }
}
