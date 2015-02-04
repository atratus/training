/**
 * 
 */
package kb.train;

import kb.train.bean.ListNode;

/**
 * @author dmitry.paramzin
 *
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null) {
    		return null;
    	}
    	if(n < 1) {
    		return head;
    	}
    		
        ListNode candidate = null;
        ListNode prevCandidate = null;
        ListNode cur = head;
        int nodeIdx = 1;
        while(cur != null) {
        	if(candidate == null) {
	        	if(nodeIdx == n) {
	        		candidate = head;
	        	}
        	} else {
        		prevCandidate = candidate;
        		candidate = candidate.next;
        	}
        	cur = cur.next;
        	nodeIdx++;
        }
        
        if(candidate != null) {
        	if(prevCandidate != null) {
        		prevCandidate.next = candidate.next;
        	} else {
        		head = candidate.next;
        	}
        }
        return head;
    }

}
