/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = getMidAndSplitInHalf(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left,right);
    }
    
    private ListNode getMidAndSplitInHalf(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
        
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left == null) {
            curr.next = right;
        }
        if (right == null) {
            curr.next = left;
        }
        return dummy.next;
        
    }
}
