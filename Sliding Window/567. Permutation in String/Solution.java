class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int start = 0;
        int match =0;
        Map<Character,Integer> map = new HashMap<>();
        for (char item: s1.toCharArray()) {
            map.put(item, map.getOrDefault(item,0) + 1);
        }
        
        for (int end=0; end<s2.length(); end++) {
            char right = s2.charAt(end);
            if (map.containsKey(right)) {
                map.put(right, map.get(right)-1);
                    if (map.get(right) == 0) {
                        match++;
                    }
            }
            if (match == map.size()) {
                return true;
            }
            
            if (end-start+1 >= s1.length()) {
                char left = s2.charAt(start);
                if (map.containsKey(left)) {
                    if (map.get(left) == 0) {
                        match--;
                    }
                    map.put(left, map.get(left)+1);
                    
                }
                start++;
            }
        }
        return false;
    }
}
