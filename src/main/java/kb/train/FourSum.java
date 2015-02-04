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
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> tSumTuples = new ArrayList<List<Integer>>();
		if(num != null && num.length >= 3) {
			Arrays.sort(num);
			for(int i = 0; i < num.length-3; i++) {
				if(i > 0 && num[i-1] == num[i]) continue;
				for(int j = i+1; j < num.length-2; j++) {
					if(j > i+1 && num[j-1] == num[j]) continue;
					int k = j+1;
					int l = num.length-1;
					while(k < l) {
						int sum = num[i] + num[j] + num[k] + num[l];
						if(sum < target) {
							k++;
							while(k < l && num[k-1] == num[k]) k++;
						} else if(sum > target) {
							l--;
							while(k < l && num[l+1] == num[l]) l--;
						} else {
							tSumTuples.add(Arrays.asList(num[i], num[j], num[k], num[l]));
							k++;
							while(k < l && num[k-1] == num[k]) k++;
							l--;
							while(k < l && num[l+1] == num[l]) l--;
						}
					}
				}
			}
		}
		return tSumTuples;
    }
}
