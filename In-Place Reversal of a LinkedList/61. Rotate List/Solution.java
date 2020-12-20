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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k<=0) return head;
        
        //find the length and the last node of the list
        ListNode lastNode = head;
        int listLength = 1;
        while (lastNode != null) {
            lastNode = lastNode.next;
            listLength++;
        }
        //connect the last node with the head to make it a circular list
        lastNode.next = head;
        //no need to rotate more than the length of the list
        k %= listLength;
        int skipLength = listLength - k;
        ListNode finalLastNode = head;
        for (int i=0; i < skiplength-1; i++) {
            finalLastNode = finalLastNode.next;
        }
        
        head = finalLastNode.next;
        finalLastNode.next = null;
        return head;
        
    }
}
