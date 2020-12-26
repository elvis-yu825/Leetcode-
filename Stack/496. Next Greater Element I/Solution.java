class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack();
        int[] result = new int[nums1.length];
        for (int i=nums2.length-1; i>=0;i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                map.put(nums2[i],-1);
            } else {
                map.put(nums2[i],stack.peek());
            }
            stack.push(nums2[i]);
        }
        for (int j=0; j < nums1.length; j++) {
            if (map.containsKey(nums1[j])) {
                result[j] = map.get(nums1[j]);
            } else {
                result[j] = -1;
            }
        }
        return result;
    }
}
