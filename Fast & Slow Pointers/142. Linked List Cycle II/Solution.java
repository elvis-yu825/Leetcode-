/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int cycleLength = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                cycleLength = findCycleLength(slow);
                break;
            }   
        }
        return findStart(head,cycleLength);
        
    }
    
    public static int findCycleLength(ListNode slow) {
        int cycleLength = 0;
        ListNode current = slow;
        do {
            current = current.next;
            cycleLength++;
        } while (current!= slow);
        
        return cycleLength;
    }
    
    public static ListNode findStart(ListNode head, int length) {
        if (length == 0) return null;
        ListNode pointer1 = head, pointer2 = head;
        while (length>0) {
            pointer2 = pointer2.next;
            length--;
        }
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }
}
