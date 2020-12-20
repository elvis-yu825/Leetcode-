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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode lastTail = null;
        ListNode resultHead = null; // head of the final reversed linkedlist
        //keep going until there are nodes in the list
        while (current != null) {
            int count = 0;
            current = head;//find the head of the next k nodes
            while (count < k && current != null) {
                current =current.next;
                count++;
                //reverse the next k nodes after we counted k nodes
                if (count == k) {
                ListNode newHead = this.reverseLinkedList(head,k);// get the new head of this k nodes
                
                if (resultHead == null) {
                    resultHead = newHead;
                }
                
                if (lastTail != null) {
                    lastTail.next = newHead;//connect the tail of the last k nodes group to current new head of this k-nodes group
                }
                    //the current k-nodes group became the last k-nodes group
                lastTail = head;// set the old head of this k-nodes group as the tail of last k-nodes group
                head = current;// the origital head of the next k-nodes group become current head
                
                }
            }
            
            
        }
        //add the remaining nodes into list;
        if (lastTail != null) {
                lastTail.next = head;
        }
        return resultHead == null ? head : resultHead;
    }
    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (k > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }
}
