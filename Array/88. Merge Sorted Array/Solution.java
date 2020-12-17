class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int high = m + n -1;
        int up = m-1, down = n-1;
        while (up>=0 && down >= 0) {
            if (nums1[up] > nums2[down]) {
                nums1[high] = nums1[up];
                high--;
                up--;
            } else {
                nums1[high] = nums2[down];
                high--;
                down--;
            }
        }
        
        while (down >=0) {
            nums1[high] = nums2[down];
            high--;
            down--;
        }
        
    }
}
