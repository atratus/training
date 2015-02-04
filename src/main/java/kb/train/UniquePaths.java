/**
 * 
 */
package kb.train;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dmitry.paramzin
 *
 */
public class UniquePaths {
	private Map<String, Long> cache = new HashMap<String, Long>();
    public long uniquePaths(int m, int n) {
        if(m == 0 || n == 0) {
        	return 0;
        }
        if(m == 1 || n == 1) {
        	return 1;
        }
        String key = m+"|"+n;
        if(cache.containsKey(key)) {
        	return cache.get(key);
        }
        long c = uniquePaths(m-1, n) + uniquePaths(m, n-1);
        cache.put(key, c);
        return c;
    }
}
