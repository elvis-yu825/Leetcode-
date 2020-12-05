class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || s.length() < k) return s.length();
        int start = 0;
        int max =0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end=0; end<s.length(); end++) {
            char right = s.charAt(end);
            map.put(right, map.getOrDefault(right,0)+1);
            
            while(map.size() > k) {
                char left = s.charAt(start);
                map.put(left, map.get(left)-1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                start++;
            }
            max = Math.max(max,end-start+1);
        }
        
        return max;
        
        
    }
}
