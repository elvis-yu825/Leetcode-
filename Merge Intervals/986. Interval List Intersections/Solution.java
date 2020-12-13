class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<int[]>();
        while (i < A.length && j < B.length) {
            // overlap exists if either interval's start lies within another interval
            if ((A[i][0] >= B[j][0] && A[i][0]<= B[j][1] ) || 
                (B[j][0]>= A[i][0] && B[j][0]<= A[i][1])) {
            result.add(new int[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])}); 
            }// store the intersection part(maxStart, MinEnd)
            
            if (A[i][1] < B[j][1]) { // interval which finishes first will move next first
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
        
    }
}
