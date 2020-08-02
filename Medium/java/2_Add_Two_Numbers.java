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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode head = new ListNode(0, null);
    	ListNode prev = head;
    	int temp1 = 0, temp2 = 0, addone = 0;
        
        while(l1 != null || l2 != null) {
        	if (l1 != null) 
        		temp1 = l1.val;
        	if (l2 != null)
        		temp2 = l2.val;
        	
        	int sum = temp1 + temp2 + addone; 
        	if (sum >= 10) {
        		addone = 1;
        		sum -= 10;
        	} else {
        		addone = 0;
        	}

        	ListNode next = new ListNode(sum);
        	prev.next = next;
        	prev = prev.next;
        	if (l1 != null)
        		l1 = l1.next;
        	if (l2 != null)
        		l2 = l2.next;

        	temp1 = 0;
        	temp2 = 0;
        }

        if (addone == 1) {
        	ListNode next = new ListNode(1);
        	prev.next = next;
        }

        return head.next;
    }
}