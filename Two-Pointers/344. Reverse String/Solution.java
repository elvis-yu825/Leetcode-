class Solution {
    public void reverseString(char[] s) {
        int low = 0;
        int high = s.length-1;
        while (low < high) {
            swap(s,low,high);
            low++;
            high--;
        }
        
    }
    
    private static void swap(char[] s, int low, int high) {
        char temp = s[low];
        s[low] = s[high];
        s[high] = temp;
    }
}
