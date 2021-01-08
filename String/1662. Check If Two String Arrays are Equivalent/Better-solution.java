class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int idx1=0, strIdx1=0, idx2=0, strIdx2=0;
        while (strIdx1<word1.length && strIdx2<word2.length) {
            if (word1[strIdx1].charAt(idx1) != word2[strIdx2].charAt(idx2)) return false;
            if (idx1 == word1[strIdx1].length()-1) {
                idx1=0;
                strIdx1++;
            } else {
                idx1++;
            }
            if (idx2 == word2[strIdx2].length()-1) {
                idx2=0;
                strIdx2++;
            } else {
                idx2++;
            }
            
        }
        return strIdx1 == word1.length && strIdx2==word2.length;
        
    }
}
