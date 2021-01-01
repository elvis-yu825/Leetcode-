class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start<=end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return isPalindrome(s,start,end-1) || isPalindrome(s, start+1, end);
            }
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int x, int y) {
        while (x<=y) {
            if (s.charAt(x) == s.charAt(y)) {
                x++;
                y--;
            } else {
                return false;
            }
        }
        return true;
    }
}
