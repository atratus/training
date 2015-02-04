/**
 * 
 */
package kb.train;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dmitry.paramzin
 *
 */
public class ThreeSumClosestTest extends AbstractProblemTest<ThreeSumClosest>{

	public ThreeSumClosestTest() {
		super(ThreeSumClosest.class);
	}

	@Test
	public void test1() {
		int c = problem().threeSumClosest(new int[]{100}, 51);
		Assert.assertEquals(100, c);
	}
	@Test
	public void test2() {
		int c = problem().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
		Assert.assertEquals(2, c);
	}
	@Test
	public void test3() {
		int c = problem().threeSumClosest(new int[]{0,0,0}, 1);
		Assert.assertEquals(0, c);
	}
	
	@Test
	public void test4() {
		int c = problem().threeSumClosest(
				new int[]{-11,-2,17,-16,1,-5,-5,-5,-20,7,10,-2,3,-7,-17,-13,-19,-15,-8,-7,6,-6,-8,-4,12,-12,9,-17,-13,4,-5,-15,-9,-18,-17,1,-15,-8,14,8,20,-3,-11,17,-18,10,-16,5,-9,-18,2,-3,4,-18,2,20,0,-6,18,-12,0,-17,3,-19,-20,15,12,-17,-7,8,16,7,-5,5,-13,16,-18,-7,-9,-8,-17,6,-18,0,-15,10,-13,7,9,20,7,-13,3,0,0,19,8,0,-5,-9,6,8,16,14,3,-4,5,9,-12,-19,16,6}, -48);
		Assert.assertEquals(-48, c);
	}
}
