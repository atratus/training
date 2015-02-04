/**
 * 
 */
package kb.train;

import kb.train.bean.ListNode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dmitry.paramzin
 *
 */
public class SwapNodesInPairsTest extends AbstractProblemTest<SwapNodesInPairs> {

	public SwapNodesInPairsTest() {
		super(SwapNodesInPairs.class);
	}

	@Test
	public void test1() {
		ListNode result = problem().swapPairs(new ListNode(1,
				new ListNode(2,
						new ListNode(3,
								new ListNode(4)))));
		
		Assert.assertEquals(2, result.val);
	}
}
