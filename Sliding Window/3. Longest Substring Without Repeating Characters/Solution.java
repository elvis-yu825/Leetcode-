class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        
        for (int end=0; end<s.length(); end++) {
            char right = s.charAt(end);
            if (map.containsKey(right)) {
                start = Math.max(start,map.get(right) +1);
                // avoid the situation like "abba":
                //if end = 3, bc map still containes "a", start will go back to 1 pointing to first "b". 
                //we should restrict it at least the new start should be greater than or equal to the old start
            }
            map.put(right,end);
            max = Math.max(max, end-start+1);
            
        }
        return max;
        
    }
}
