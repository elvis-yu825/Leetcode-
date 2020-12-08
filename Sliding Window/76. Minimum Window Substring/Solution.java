class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int match =0;
        int resultStart = 0;
        int min = s.length()+1;
        
        Map<Character,Integer> map = new HashMap<>();
        for (char item: t.toCharArray()) {
            map.put(item,map.getOrDefault(item, 0)+1);
        }
        
        for (int end=0; end<s.length(); end++) {
            char right = s.charAt(end);
            if (map.containsKey(right)) {
                map.put(right,map.get(right)-1);
                if(map.get(right) >= 0) {
                    match++;
                }
            }
            
            while(match == t.length()) {
                if(min > end-start+1) {
                    min = end-start+1;
                    resultStart = start;
                }
                
                char left = s.charAt(start++);
                if (map.containsKey(left)) {
                    if (map.get(left) == 0) {
                        match--;
                    }
                    map.put(left,map.get(left)+1);
                    
                }
                
            }
        }
        
        return min > s.length() ? "" : s.substring(resultStart, resultStart+min);
    }
}
