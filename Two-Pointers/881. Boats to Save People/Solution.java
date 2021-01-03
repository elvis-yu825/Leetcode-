class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        int low = 0;
        int high = people.length-1;
        Arrays.sort(people);
        while (low <= high) {
            count++;
            if (people[low]+people[high]>limit) {
                high--;
            } else {
                low++;
                high--;
            }
            
        }
        return count;
        
    }
}
