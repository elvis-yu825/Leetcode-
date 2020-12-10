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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        //find middle of the linkedlist
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast = fast.next.next;
        }
        ListNode headSecondHalf = reverse(slow); //reverse the second half
        ListNode copyHeadSecondHalf = headSecondHalf;// save the head of the reversed part for 
        //reverse back later
        //compare the first and second half
        while (head!=null && headSecondHalf!= null) {
            if (head.val != headSecondHalf.val) {
                break; // not a palindrome
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }
        
        reverse(copyHeadSecondHalf); // revert the reverse of the second half
        if (head == null || headSecondHalf == null) // if both halves match
            return true;
        return false;    
    }
    //Helper Function to reverse the Linked List
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
