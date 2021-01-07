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
    public ListNode insertionSortList(ListNode head) {
        ListNode dumm = new ListNode();
        ListNode curr = head;
        while (curr != null) {
            ListNode prev = dumm;
            while (prev.next != null && prev.next.val < curr.val) {
                prev= prev.next;
            }
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        return dumm.next;
        
    }
}
