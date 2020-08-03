import java.util.List;

class MyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index == size - 1)
            return tail.val;
        if (index >= size)
            return -1;
        ListNode traverse = head;
        for (int i = 0; i < index; i ++) {
            traverse = traverse.next;
        }
        return traverse.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode addedNode = new ListNode(val);
        if (head == null) {
            head = addedNode;
            tail = addedNode;
            size ++;
            return;
        }

        head.prev = addedNode;
        addedNode.next = head;
        head = addedNode;
        size ++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode addedNode = new ListNode(val);
        if (tail == null) {
            head = addedNode;
            tail = addedNode;
            size ++;
            return;
        }

        tail.next = addedNode;
        addedNode.prev = tail;
        tail = addedNode;
        size ++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode t = head;
        //System.out.println(size);
        //for (int i = 0; i < size; i ++)
        //    System.out.println(get(i));

        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (index > size || index < 0) {
            return;
        } else {
            ListNode prev = head;
            ListNode next = head.next;
            for (int i = 0; i < index - 1; i ++) {
                prev = prev.next;
                next = next.next;
            }
            ListNode addedNode = new ListNode(val);
            addedNode.prev = prev;
            addedNode.next = next;
            prev.next = addedNode;
            next.prev = addedNode;
            size ++;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || size == 0)
            return;
        if (index == 0 && size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head.next.prev = null;
            head = head.next;
        } else if (index == size - 1) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            ListNode traverse = head;
            for (int i = 0; i < index; i ++) {
                traverse = traverse.next;
            }
            if (traverse.next != null) {
                traverse.next.prev = traverse.prev;
            }
            traverse.prev.next = traverse.next;
        }
        size --;
    }
}

class ListNode {

    public ListNode next;
    public ListNode prev;
    public int val;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
