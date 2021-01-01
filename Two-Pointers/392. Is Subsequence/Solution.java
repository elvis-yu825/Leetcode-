class Solution {
    public boolean isSubsequence(String s, String t) {
        int go = 0;
        int check = 0;
        while (go < s.length() && check < t.length()) {
            if (s.charAt(go) == t.charAt(check)) {
                go++;
            } 
            check++;
        }
        return go == s.length();
        
    }
}
