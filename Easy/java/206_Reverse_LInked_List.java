/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
    	if (head == null || head.next == null)
    		return head;
    	Stack<ListNode> stack = new Stack<>();
    	ListNode tail = head;
    	ListNode temp = head;
    	while (head != null) {
    		stack.push(head);
    		head = head.next;
    	}
    	tail = stack.peek();
    	while( !stack.isEmpty()) {
    		temp = stack.pop();
    		if (!stack.isEmpty())
    			temp.next = stack.peek();
    		else
    			temp.next = null;
    	}
    	return tail;
    }
}



class Solution {

    public ListNode reverseList(ListNode head) {
    	if (head == null)
    		return head;
    	if (head.next == null) {
    		return head;
    	}
    	ListNode tail = reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
    	return tail;
    }
    	
}