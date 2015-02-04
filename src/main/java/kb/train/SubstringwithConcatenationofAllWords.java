/**
 * 
 */
package kb.train;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author dmitry.paramzin
 *
 */
public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
    	List<Integer> substringIdxs = new ArrayList<Integer>();
    	Map<String, Integer> dictWordsCount = new HashMap<String, Integer>();
    	if(L.length < 1) {
    		return substringIdxs;
    	}
    	int dwlen = L[0].length();
    	for(String word:L) {
    		if(dictWordsCount.containsKey(word)) {
    			dictWordsCount.put(word, dictWordsCount.get(word)+1);
    		} else {
    			dictWordsCount.put(word, 1);
    		}
    	}
    	
    	
    	int dwordsTotal = L.length;
    	for(int i = 0; i < dwlen; i++) {
    		int startSeqIdx = -1;	
        	Map<String, Integer> dictWordsCountdown = new HashMap<String, Integer>(dictWordsCount);
        	int dwordsTotalCountdown = L.length;
    		for(int j = i; j < S.length(); j+=dwlen) {
        		int startIdx = j;
        		int endIdx = startIdx+dwlen;
        		String candidate = S.substring(startIdx, Math.min(endIdx, S.length()));
        		Integer remainingCounts = dictWordsCountdown.get(candidate);
        		if(remainingCounts != null) {
        			if(remainingCounts > 0) {
        				// We are still in sequence
        				
	        			dictWordsCountdown.put(candidate, --remainingCounts);
	        			if(startSeqIdx == -1) {
	        				startSeqIdx = startIdx;
	        			}
	        			dwordsTotalCountdown--;
	        			
            			if(dwordsTotalCountdown == 0/* && !firstInSeq.equals(candidate)*/) {
	        				substringIdxs.add(startSeqIdx);
            			}
        			} else if(dwordsTotalCountdown > 0){
        				// Sequence is interrupted
        				if(startSeqIdx != -1) {
        					int k = startSeqIdx+dwlen;
        					while(k < startIdx && !candidate.equals(S.substring(k, k+dwlen))) {
            	        		String item = S.substring(k, k+dwlen);
        	        			dictWordsCountdown.put(item, dictWordsCountdown.get(item)+1);
        	        			k += dwlen;
        					}
                			startSeqIdx = k-dwlen;
        				}
        			}
        			
        			if(dwordsTotalCountdown == 0) { //End of sequence
            			dwordsTotalCountdown++;
            			String firstInSeq = S.substring(startSeqIdx, startSeqIdx+dwlen);
            			dictWordsCountdown.put(firstInSeq, dictWordsCountdown.get(firstInSeq)+1);
            			startSeqIdx += dwlen;
        			}
        		} else {
        			dictWordsCountdown = new HashMap<String, Integer>(dictWordsCount);
        			dwordsTotalCountdown = dwordsTotal;
        			startSeqIdx = -1;
        		}
        	}
    	}
    	return new ArrayList<Integer>(new HashSet<Integer>(substringIdxs));
        
    }
    
} 