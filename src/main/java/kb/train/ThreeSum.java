/**
 * 
 */
package kb.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dmitry.paramzin
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> zSumTuples = new ArrayList<List<Integer>>();
		if(num != null && num.length >= 3) {
			Arrays.sort(num);
			for(int i = 0; i < num.length-2;i++) {
				int j = i+1;
				int k = num.length-1;
				if(i > 0 && num[i] == num[i-1]) {
					continue;
				}
				while(j < k) {
					int sum = num[i] + num[j] + num[k];
					if(sum < 0) {
						j++;
						while(j < k && num[j-1] == num[j]) {
							j++;
						}
					} else if(sum > 0) {
						k--;
						while(j < k && num[k+1] == num[k]) {
							k--;
						}
					} else {
						zSumTuples.add(Arrays.asList(num[i], num[j], num[k]));
						k--;
						while(j < k && num[k+1] == num[k]) {
							k--;
						}
						j++;
						while(j < k && num[j-1] == num[j]) {
							j++;
						}
					}
				}
			}
		}
		return zSumTuples;
	}
}
