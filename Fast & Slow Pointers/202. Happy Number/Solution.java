class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while (slow!=fast);
        
        return slow == 1;
    }
    
    public static int findSquareSum(int num) {
        int sum=0, dig;
        while(num>0) {
            dig = num % 10;
            sum += dig * dig;
            num /= 10;
        }
        return sum;
    }
}
