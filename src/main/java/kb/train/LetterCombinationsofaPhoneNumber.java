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
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *  
 * @author dmitry.paramzin
 *
 */
public class LetterCombinationsofaPhoneNumber {
	private final static Map<Character, char[]> charsMapping = new HashMap<Character, char[]>();
	static {
		charsMapping.put('0', new char[]{});
		charsMapping.put('1', new char[]{' '});
		charsMapping.put('2', new char[]{'a', 'b', 'c'});	
		charsMapping.put('3', new char[]{'d', 'e', 'f'});	
		charsMapping.put('4', new char[]{'g', 'h', 'i'});	
		charsMapping.put('5', new char[]{'j', 'k', 'l'});	
		charsMapping.put('6', new char[]{'m', 'n', 'o'});	
		charsMapping.put('7', new char[]{'p', 'q', 'r', 's'});	
		charsMapping.put('8', new char[]{'t', 'u', 'v'});	
		charsMapping.put('9', new char[]{'w', 'x', 'y', 'z'});
	}
    public List<String> letterCombinations(String digits) {
    	if(digits == null || digits.length() == 0) {
    		return Collections.singletonList("");
    	}
    	int[] currentPermutation = new int[digits.length()];
    	
    	int lastUpdatedIdx = 0;
    	List<String> possiblePermutations = new ArrayList<String>();
    	do {
    		possiblePermutations.add(perm(currentPermutation, digits));
    		
        	lastUpdatedIdx = 0;
    		while(
    			lastUpdatedIdx < currentPermutation.length &&
    			currentPermutation[lastUpdatedIdx] == charsMapping.get(digits.charAt(lastUpdatedIdx)).length-1) {
    			
    				currentPermutation[lastUpdatedIdx] = 0;
    				lastUpdatedIdx++;
    		}
    		if(lastUpdatedIdx != currentPermutation.length) {
				currentPermutation[lastUpdatedIdx]++;
    		}
    			
    	} while (lastUpdatedIdx != currentPermutation.length);
    	return possiblePermutations;
    }
	private String perm(int[] currentPermutation, String digits) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < currentPermutation.length; i++) {
			int mappedIdx = currentPermutation[i];
			sb.append(charsMapping.get(digits.charAt(i))[mappedIdx]);
		}
		return sb.toString();
	}

}
