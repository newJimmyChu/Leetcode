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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (n == 0) 
    		return head;
    	if (head.next == null && n == 1) 
    		return null;

        ListNode front = head;
        ListNode follow = head;
        ListNode prev = null;

        for (int i = 0; i < n; i ++) {
        	if (front != null)
        		front = front.next;
        	else
        		return null;
        }

        while (front != null) {
        	prev = follow;
        	front = front.next;
        	follow = follow.next;
        }
        if (prev != null)
        	prev.next = follow.next;
        else
        	head = head.next;

        return head;
    }
}