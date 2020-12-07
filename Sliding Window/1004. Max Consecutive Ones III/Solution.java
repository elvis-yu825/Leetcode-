class Solution {
    public int longestOnes(int[] A, int K) {
        int start = 0;
        int max = 0;
        int result = 0;

        
        for (int end=0; end<A.length; end++) {
            if (A[end] ==1) {
                max++;
            }

            
            if (end-start+1-max > K) {
                if (A[start] == 1) {
                    max--;
                }
                start++;
            }
            result = Math.max(result, end-start+1);
        }
        return result;
        
    }
}
