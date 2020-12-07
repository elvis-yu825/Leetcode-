class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int max = 0;
        int result = 0;
        Map<Character,Integer> map = new HashMap<>();
        
        for (int end=0; end<s.length(); end++) {
            char right = s.charAt(end);
            map.put(right,map.getOrDefault(right,0)+1);
            max = Math.max(max,map.get(right));
            
            if (end-start+1-max > k) {
                char left = s.charAt(start);
                map.put(left,map.get(left)-1);
                start++;
            }
            result = Math.max(result,end-start+1);
        }
        return result;
    }
}
