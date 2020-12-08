class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int start=0;
        int match=0;
        List<Integer> result = new ArrayList<Integer>();
        Map<Character,Integer> map = new HashMap<>();
        for (char item: p.toCharArray()) {
            map.put(item, map.getOrDefault(item,0)+1);
        }
        
        for (int end=0; end<s.length();end++) {
            char right = s.charAt(end);
            if (map.containsKey(right)) {
                map.put(right, map.get(right)-1);
                if (map.get(right) == 0) {
                    match++;
                }
            }
            
            if (match == map.size()) {
                result.add(start);
                
            }
            
            if (end-start+1 >= p.length()) {
                char left= s.charAt(start);
                if (map.containsKey(left)) {
                    if (map.get(left) == 0) {
                        match--;
                    }
                    map.put(left, map.get(left)+1);
                }
                start++;
            }
            
        }
        
        return result;
        
    }
}
