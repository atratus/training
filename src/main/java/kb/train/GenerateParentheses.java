/**
 * 
 */
package kb.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dmitry.paramzin
 *
 */
public class GenerateParentheses {
	Map<Integer, List<String>> cache = new HashMap<Integer, List<String>>();
    public List<String> generateParenthesis(int n) {
        if(n == 0) {
        	return Collections.singletonList("");
        }
        if(n == 1) {
        	return Collections.singletonList("()");
        }
        if(cache.containsKey(n)) {
        	return cache.get(n);
        }
        
        List<String> parenthesesList = new ArrayList<String>();
        for(int i = 0; i < n; i++) {
        	List<String> leftList = generateParenthesis(i);
        	List<String> rightList = generateParenthesis(n-1-i);
        	for(String leftParenteseses:leftList) {
            	for(String rightParenteseses:rightList) {
            		String combination = leftParenteseses + "(" + rightParenteseses + ")";
            		parenthesesList.add(combination);
            	}
        	}
        }
        
        cache.put(n, parenthesesList);
        return parenthesesList;
    }

}
