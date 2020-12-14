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
    public ListNode mergeKLists(ListNode[] lists) {
        // build a comparator to compare node.val
        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }    
        };
        //build a queque with the above comparator
        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        for (ListNode l : lists) {
            if (l != null) {
                q.add(l); // add all list into the queue
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (!q.isEmpty()) {
            point.next = q.poll();//pop out the smallest number in the queue
            point = point.next;
            ListNode next = point.next;
            if (next != null) {
                q.add(next);//add the next number of the poped number in the list to queue
            }
        }
        
        return head.next;
        
    }
}
