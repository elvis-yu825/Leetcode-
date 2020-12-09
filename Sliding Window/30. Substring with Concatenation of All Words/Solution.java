class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for (String item:words) {
            map.put(item, map.getOrDefault(item,0)+1);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int wordCount = words.length;
        int wordLength = words[0].length();
        
        for (int i=0; i<=s.length()-wordCount * wordLength; i++) {
            Map<String,Integer> map1 = new HashMap<>();
            
            for (int j=0; j<wordCount; j++) {
                int nextWordStart = i + j * wordLength;
                String word = s.substring(nextWordStart, nextWordStart+wordLength);
                
                if (!map.containsKey(word)) {
                    break;
                }
                
                map1.put(word, map1.getOrDefault(word,0)+1);
                
                if (map1.get(word) > map.getOrDefault(word,0)) {
                    break;
                }
                
                if (j+1 == wordCount) {
                    result.add(i);
                }
            }
            
        }
        
        return result;
    }
}
