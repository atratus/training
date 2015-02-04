/**
 * 
 */
package kb.train;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dmitry.paramzin
 *
 */
public class FourSumTest extends AbstractProblemTest<FourSum> {

	public FourSumTest() {
		super(FourSum.class);
	}
	
	@Test
	public void test1() {
		List<List<Integer>> result = problem().fourSum(new int[]{1,0,-1,0,-2,2}, 0);
		Assert.assertEquals(3, result.size());
	}

}
