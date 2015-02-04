/**
 * 
 */
package kb.train;

/**
 * @author dmitry.paramzin
 *
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
    	if(A.length == 0) {
    		return -1;
    	}
    	if(A.length == 1) {
    		return A[0] == target ? 0 : -1;
    	}
        int fallPoint = findFall(A);
        
        int idx = binarySearch(A, target, 0, fallPoint);
        if(idx != -1) {
        	return idx;
        }
        
        return binarySearch(A, target, fallPoint, A.length);
    }

	private int binarySearch(int[] a, int target, int startInclusive, int endExclusive) {
		int st = startInclusive;
		int end = endExclusive-1;
		while(end > st) {
			int m = (end+st)/2;
			if(a[m] > target) {
				end = m;
			} else if(a[m] < target) {
				st = m;
				if(end-st == 1) {
					return a[st] == target ? st : (a[end] == target ? end : -1);
				}
			} else {
				return m;
			}
		}
		return a[st] == target ? st : -1;
	}

	private int findFall(int[] a) {
		int gap = 1;
		int idx = 1;
		int prevIdx = 0;
		while(idx < a.length-1 || idx-prevIdx > 1) {
			if(idx+gap > a.length-1) {
				idx -= gap;
				gap >>>= 1;
			} else if(a[idx] < a[prevIdx]) {
				if(idx-prevIdx <= 1) {
					return idx;
				}
				idx -= gap;
				gap >>>= 1;
			} else {
				gap <<= 1;
			}
			prevIdx = idx;
			idx += gap;
		}
		return idx;
	}

}
