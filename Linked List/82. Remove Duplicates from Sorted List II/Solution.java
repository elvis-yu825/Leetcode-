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
    public ListNode deleteDuplicates(ListNode head) {
        //create a sentinel node to avoid situation:
        //head is also a duplicate
        ListNode sentinel = new ListNode(0,head);
        //pred is the last node before the sublist of duplicates
        ListNode pred = sentinel;
        while (head !=null) {
            //if its the beginning of duplicates sublist
            //skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                //move till the end of the duplicates list
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                //skip all duplicates since head is now the last node of 
                //the duplicates list
                pred.next = head.next;
            }
            //move pred if no duplicates
            else {
                pred = pred.next;
            }
            //move forward
            head = head.next;
        }
        return sentinel.next;
    }
}
