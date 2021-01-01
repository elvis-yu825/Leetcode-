class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        //initialize hashmap
        Map<Integer,int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        
        int i=0;
        while (i<n) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int[] targetPiece = map.get(arr[i]);
            for (int item : targetPiece) {
                if (item != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
        
    }
}
