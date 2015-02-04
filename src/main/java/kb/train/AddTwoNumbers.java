/**
 * 
 */
package kb.train;

import kb.train.bean.ListNode;

/**
 * @author black
 *
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode cL1 = l1;
    	ListNode cL2 = l2;
        
    	ListNode sumL = null;
    	boolean carry = false;
    	while(cL1 != null || cL2 != null) {
    		int d1 = cL1 == null ? 0 : cL1.val;
    		int d2 = cL2 == null ? 0 : cL2.val;
    		int s = d1+d2;
    		if(carry) {
    			s += 1;
    		}
    		ListNode dS = new ListNode(s%10);
    		carry = dS.val != s;
    		dS.next = sumL;
    		sumL = dS;
    		if(cL1 != null) {
    			cL1 = cL1.next;
    		}
    		if(cL2 != null) {
    			cL2 = cL2.next;
    		}
    	}
		if(carry) {
    		ListNode dS = new ListNode(1);
    		dS.next = sumL;
    		sumL = dS;
		}
    	
    	
    	return revert(sumL);
    }

	private ListNode revert(ListNode sumL) {
		if(sumL == null) {
			return null;
		}
		ListNode prev = null;
		ListNode cur = sumL;
		while(cur.next != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		cur.next = prev;
		return cur;
	}

}
