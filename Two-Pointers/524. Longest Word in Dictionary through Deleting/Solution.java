class Solution {
    public String findLongestWord(String s, List<String> d) {
        String max = "";
        for (String str:d) {
            if (isSubsequence(str,s)) {
                if (str.length() >max.length() || (str.length() == max.length() &&
                                                  str.compareTo(max) < 0)) {
                    max = str;
                }
            }
        }
        return max;
    }
    
    private static boolean isSubsequence(String test, String s) {
        int j = 0;
        for (int i=0; i<s.length() && j<test.length(); i++) {
            if (s.charAt(i) == test.charAt(j)) {
                j++;
            }
        }
        return j == test.length();
    }
}
