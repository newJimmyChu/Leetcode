/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
    	if (head == null)
    		return null;
    	if (head.child != null && head.next == null) {
    		connect(head.child, head, null);
    		head.child = null;
    		return head;
    	}
    		
    	
    	Node prev = head, tail = head.next;
        while (tail != null) {
        	if (prev.child != null) {
        		connect(prev.child, prev, tail);
        		prev.child = null;
        	}
        	prev = tail;
        	tail = tail.next;
        }

        if (prev.child != null) {
        	connect(prev.child, prev, null);
        	prev.child = null;
        }

        return head;
    }

    public void connect(Node cur, Node first, Node second) {
    	
    	first.next = cur;
    	cur.prev = first;

    	if (cur.next == null && cur.child != null) {
    		connect(cur.child, cur, second);
    		cur.child = null;
    	}

    	while (cur.next != null) {
    		if (cur.child != null) {
    			connect(cur.child, cur, cur.next);
    			cur.child = null;
    		} 
    		cur = cur.next;
    	}
    	if (cur.child != null)
    		connect(cur.child, cur, null);
    		cur.child = null;

    	cur.next = second;
    	if (second != null)
    		second.prev = cur;
    }
}