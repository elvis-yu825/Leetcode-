class Solution {
    public String removeVowels(String s) {
        Set<Character> set = new HashSet<>
            (Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        StringBuffer result = new StringBuffer();
        for (int i=0; i<s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
        
    }
}
