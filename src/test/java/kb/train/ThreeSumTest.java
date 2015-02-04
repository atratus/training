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
public class ThreeSumTest extends AbstractProblemTest<ThreeSum>{

	public ThreeSumTest() {
		super(ThreeSum.class);
	}
	
	@Test
	public void test1() {
		List<List<Integer>> result = problem().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
		Assert.assertEquals(2, result.size());
	}
	
	@Test
	public void test2() {
		List<List<Integer>> result = problem().threeSum(new int[]{-2,0,1,1,2});
		Assert.assertEquals(2, result.size());
	}
	
	@Test
	public void test3() {
		List<List<Integer>> result = problem().threeSum(new int[]{-2,0,0,2,2});
		Assert.assertEquals(1, result.size());
	}
}
