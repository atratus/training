/**
 * 
 */
package kb.train;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kb.train.bean.ListNode;

/**
 * @author dmitry.paramzin
 *
 */
public class MergekSortedLists {
	
    public ListNode mergeKLists(List<ListNode> lists) {
    	if(lists == null || lists.isEmpty()) {
    		return null;
    	}
    	
    	//int tailsCount = tails.length;

    	List<ListNode> curLists = new ArrayList<ListNode>(lists);

    	while(curLists.size() > 1) {
    		ListNode l1 = null;
        	List<ListNode> mergedLists = new ArrayList<ListNode>(curLists.size()/2+1);
	    	for(Iterator<ListNode> it = curLists.iterator(); it.hasNext();) {
	    		l1 = it.next();
	    		if(it.hasNext()) {
		    		ListNode l2 = it.next();
		    		ListNode merged = merge(l1, l2);
		    		mergedLists.add(merged);
	    		} else {
	    			mergedLists.add(l1);
	    		}
	    	}
	    	curLists = mergedLists;
    	}
    	
		return curLists.get(0);
    }

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode root = null;
		ListNode prev = null;
		
    	while(l1 != null || l2 != null) {
    		ListNode nextNode = null;
    		if(l1 != null && l2 != null) {
    			if(l1.val < l2.val) {
    				nextNode = l1;
    				l1 = l1.next;
    			} else {
    				nextNode = l2;
    				l2 = l2.next;
    			}
    		} else if(l1 != null) {
				nextNode = l1;
				l1 = l1.next;
    		} else if(l2 != null) {
				nextNode = l2;
				l2 = l2.next;
    		}
    		if(root == null) {
    			root = nextNode;
    		}
    		if(prev != null) {
    			prev.next = nextNode;
    		}
    		prev = nextNode;
    		prev.next = null;
    	}
		return root;
	}

}
