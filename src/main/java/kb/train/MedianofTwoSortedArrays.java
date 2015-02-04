/**
 * 
 */
package kb.train;

import java.util.Arrays;

/**
 * @author dmitry.paramzin
 *
 */
public class MedianofTwoSortedArrays {
	
    public double findMedianSortedArrays(int A[], int B[]) {
    	return rFindMedianSortedArrays(A, 0, A.length, B, 0, B.length);
    }
    public double rFindMedianSortedArrays(int A[], int aL, int aR, int B[], int bL, int bR) {

    	int aSize = aR-aL;
    	int bSize = bR-bL;
    	
    	if(bSize < aSize) {
    		return rFindMedianSortedArrays(B, bL, bR, A, aL, aR);
    	}

    	if(bSize == 0) {
    		return 0.0;
    	}
    	if(aSize == 0) {
    		return mid(Arrays.copyOfRange(B, bL, bR));
    	}
    	if(bSize == 1) {//=> A==1
    		return (B[bL]+A[aL])/2.0;
    	}
    	int bHalfIdx = (bL+bR-1)/2;
    	if(aSize == 1) {
    		if((bSize&1) == 1) {
    			//B is odd
    			return (mid(A[aL], B[bHalfIdx-1], B[bHalfIdx+1])+B[bHalfIdx])/2.0;
    		} else {
    			//B is even
    			return mid(A[aL], B[bHalfIdx], B[bHalfIdx+1]);
    		}
    	} else if(aSize == 2) {
    		if(bSize == 2) {
    			return mid(A[aL], A[aR-1], B[bL], B[bR-1]);
    		} else if((bSize&1) == 1) {
    			//B is odd
    			return mid(Math.max(A[aL], B[bHalfIdx-1]), B[bHalfIdx], Math.min(A[aR-1], B[bHalfIdx+1]));
    		} else {
    			//B is even
    			return mid(Math.max(A[aL], B[bHalfIdx-1]), B[bHalfIdx], B[bHalfIdx+1], Math.min(A[aR-1], B[bHalfIdx+2]));
    		}
    	}

    	int aHalfIdx = (aL + aR-1)/2;
    	double medA = (aSize&1) == 1 ? A[aHalfIdx] : (A[aHalfIdx] + A[aHalfIdx+1])/2.0;
    	double medB = (bSize&1) == 1 ? B[bHalfIdx] : (B[bHalfIdx] + B[bHalfIdx+1])/2.0;
    	if(medA < medB) {
    		return rFindMedianSortedArrays(A, aHalfIdx, aR, B, bL, bR-(aHalfIdx-aL));
    	} else if(medA > medB) {
			return rFindMedianSortedArrays(A, aL, (aL + aR)/2+1, B, bL+(aHalfIdx-aL), bR);
    	} else {
    		return medA;
    	}
    }
    

	private double mid(int... arr) {
		if(arr.length == 1) {
			return arr[0];
		}
		Arrays.sort(arr);
		int start = 0; int end = arr.length;
		int mIdx = (start+end-1)/2;
		return (((end-start)&1) == 1) ?
				arr[mIdx]: //Even
					(arr[mIdx] + arr[mIdx+1])/2.0;//Odd
	}
}