/**
 * 
 */
package kb.train;

import kb.train.bean.ListNode;

/**
 * @author dmitry.paramzin
 *
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
    	if(head == null) {
    		return null;
    	}
    	ListNode current = head;
    	ListNode prev = null;
    	ListNode newHead = current;//!
    	while(current != null && current.next != null) {
    		ListNode nextNext = current.next.next;
    		current.next.next = current;
    		if(prev == null) {
    			newHead = current.next;
    		} else {
    			prev.next = current.next;
    		}
    		current.next = nextNext;
    		prev = current;
    		current = nextNext;
    	}
    	return newHead;
    }

}
