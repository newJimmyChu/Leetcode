/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.*;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	Stack<Integer> stack = new Stack<>();
    	while (listNode != null) {
    		stack.add(listNode.val);
    		listNode = listNode.next;
    	}
    	ArrayList<Integer> list = new ArrayList<>();
    	while (!stack.isEmpty()) {
    		list.add(stack.pop());
    	}
    	return list;
    }
}

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	ArrayList<ListNode> list = new ArrayList<>();
    	while (listNode != null) {
    		ListNode temp = list.get(0);
    		list.add(0, listNode);
    		listNode = listNode.next;
    		if(temp != null) {
    			list.get(0).next = temp;
    		}
    	}
    	ArrayList<Integer> ret = new ArrayList<>();
    	for (ListNode node : list) {
    		ret.add(node.val);
    	}
    	return ret;
    }
}