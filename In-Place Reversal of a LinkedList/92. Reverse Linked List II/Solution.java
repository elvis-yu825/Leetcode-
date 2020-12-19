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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current = head;
        ListNode prev = null;
        // after skipping 'm-1' nodes, current will point to 'm'th node
        for (int i=0; i <m-1 && current != null; i++) {
            prev = current;
            current = current.next;
        }
        // we are interested in three parts of the LinkedList, part before index 'm', part between 'm' and 
    // 'n', and the part after index 'n'
        ListNode lastOfFirst = prev;// points to the node at index 'm-1'
        // after reversing the LinkedList 'current' will become the last node of the sub-list
        ListNode lastOfSub = current;
        ListNode next = null;// will be used to temporarily store the next node
        // reverse nodes between 'm' and 'n'
        for (int i=0; current != null && i<n-m+1;i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
         // connect with the first part
        if (lastOfFirst != null) {// 'previous' is now the first node of the sub-list
            lastOfFirst.next = prev;
        } else {// this means m == 1 i.e., we are changing the first node (head) of the LinkedList
            head = prev;
        }
        // connect with the last part
        lastOfSub.next = current;
        return head;
        
        
        
        
        
    }
}
