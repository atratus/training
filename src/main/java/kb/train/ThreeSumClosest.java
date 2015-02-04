/**
 * 
 */
package kb.train;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dmitry.paramzin
 *
 */
public class ThreeSumClosest {
	Map<String, Integer> cache = new HashMap<String, Integer>();
    public int threeSumClosest(int[] num, int target) {
		if(num == null || num.length < 3) {
			return 0;
		}
		
		Arrays.sort(num);
		
		int sum = 0;
		boolean initialized = false;
		for(int i = 0; i < num.length-2; i++) {
			int j = i+1;
			int k = num.length-1;
			while(j < k) {
				int tmpSum = num[i]+num[j]+num[k];
				if(!initialized || Math.abs(tmpSum - target) < Math.abs(sum - target)) {
					sum = tmpSum;
					initialized = true;
				}
				if(tmpSum < target) {
					j++;
				} else if(tmpSum > target) {
					k--;
				} else {
					return sum;
				}
			}
		}
        return sum;
    }
    
    public int threeSumClosest1(int[] num, int target) {
        return rThreeSumClosest(num, num.length-1, 3, target);
    }

	private int rThreeSumClosest(int[] num, int i, int d, int target) {
		if(num == null || num.length == 0) {
			return 0;
		}
		if(i == 0) {
			return 0;
		}
		if(d == 0) {
			return 0;
		}
		if(i == d) {
			int sum = 0;
			for(int k = 0; k < d;k++) {
				sum += num[k];
			}
			return sum;
		}
		String key = String.valueOf(i) + "/" + d + target;
		if(cache.containsKey(key)) {
			return cache.get(key);
		}
		int a = rThreeSumClosest(num, i-1, 3, target);
		int b = rThreeSumClosest(num, i-1, 3-1, target-num[i])+num[i];
		int c = closest(a, b, target);
		cache.put(key, c);
		return c;
	}

	private int closest(int a, int b, int target) {
		if(Math.abs(a - target) < Math.abs(b - target)) {
			return a;
		} else {
			return b;
		}
	}

}
