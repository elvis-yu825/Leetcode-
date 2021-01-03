class Solution {
    public int longestMountain(int[] A) {
        if( A == null || A.length <3) 
            return 0; 
        int ans = 0; 
        for(int i = 1; i < A.length - 1; i++ ) {
            if(A[i] > A[i-1] && A[i] > A[i+1]) {  // i is a peak
                int left = i -1;    // find leftmost of the peak
                while(left > 0 && A[left-1] < A[left])
                    left--;
                
                int right= i+1;  // find rightmost of the peak
                while(right < A.length - 1 && A[right + 1] < A[right])
                    right++;
                
                ans = Math.max(ans, right - left +1);  // get the width using left and rightmost
                
            }
        }
        return ans;
    }
}
