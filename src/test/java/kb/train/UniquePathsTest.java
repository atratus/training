/**
 * 
 */
package kb.train;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author dmitry.paramzin
 *
 */
public class UniquePathsTest extends AbstractProblemTest<UniquePaths> {

	public UniquePathsTest() {
		super(UniquePaths.class);
	}

	@Test
	public void test3x7() {
		long c = problem().uniquePaths(3, 7);
		assertEquals(28, c);
	}
	@Test
	public void test3x3() {
		long c = problem().uniquePaths(3, 3);
		assertEquals(6, c);
	}
	
	@Test
	public void test100x99() {
		long c = problem().uniquePaths(100, 99);
		assertEquals(28, c);
	}
	
	@Test
	public void test30x30() {
		long c = problem().uniquePaths(30, 30);
		assertEquals(28, c);
	}
	
}
