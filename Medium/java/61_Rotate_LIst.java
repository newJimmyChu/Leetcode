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
    	if (head == null || head.next == null  || k == 0) {
    		return head;
    	}

    	ListNode temp = head, prev = head, tail = head;
    	int count = 1;
    	while (tail.next != null) {
    		tail = tail.next;
    		count ++;
    	}

    	k %= count;

    	if (k == 0) {
    		return head;
    	}

    	for (int i = 0; i < count - k; i ++) {
    		prev = temp;
    		temp = temp.next;
    	}
    	prev.next = null;
    	tail.next = head;

    	head = temp;

        return head;
    }
}