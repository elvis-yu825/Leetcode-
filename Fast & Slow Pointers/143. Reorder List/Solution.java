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
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalfHead = reverse(slow);
        ListNode firstHalfHead = head;
        
        while (secondHalfHead.next != null) {
            ListNode temp = firstHalfHead.next;
            firstHalfHead.next = secondHalfHead;
            firstHalfHead = temp;
            
            temp = secondHalfHead.next;
            secondHalfHead.next = firstHalfHead;
            secondHalfHead = temp;
        }   
    }
    
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head!=null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
