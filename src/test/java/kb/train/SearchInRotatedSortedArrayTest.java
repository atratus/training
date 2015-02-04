/**
 * 
 */
package kb.train;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author dmitry.paramzin
 */
public class SearchInRotatedSortedArrayTest extends AbstractProblemTest<SearchInRotatedSortedArray> {

    private static final int[] ROTATED_ARRAY_1 = new int[]{4,5,6,7,8,9,1,2,3};
	private static final int[] ROTATED_ARRAY = new int[]{4, 5, 6, 7, 0, 1 ,2};
	private static final int[] NOT_ROTATED_ARRAY = new int[]{0, 1, 2, 4, 5, 6, 7};
	
	public SearchInRotatedSortedArrayTest() {
		super(SearchInRotatedSortedArray.class);
	}
	
	@Test
	public void testEmpty() {
		int idx = problem().search(new int[0], 1);
		assertEquals(-1, idx);
	}
	@Test
	public void test2() {
		int idx = problem().search(new int[]{3,1}, 1);
		assertEquals(1, idx);
	}
	@Test
	public void test2_1() {
		int idx = problem().search(new int[]{3,1}, 3);
		assertEquals(0, idx);
	}
	@Test
	public void test2_2() {
		int idx = problem().search(new int[]{3,1}, 2);
		assertEquals(-1, idx);
	}
	
	@Test
	public void testSecondHalfStart1() {
		int idx = problem().search(ROTATED_ARRAY_1, 1);
		assertEquals(6, idx);
	}
	
	@Test
	public void testSecondHalfMiddle() {
		int idx = problem().search(ROTATED_ARRAY, 1);
		assertEquals(5, idx);
	}
	@Test
	public void testSecondHalfEnd() {
		int idx = problem().search(ROTATED_ARRAY, 2);
		assertEquals(6, idx);
	}
	@Test
	public void testSecondHalfStart() {
		int idx = problem().search(ROTATED_ARRAY, 0);
		assertEquals(4, idx);
	}

	@Test
	public void testFirstHalfMiddle() {
		int idx = problem().search(ROTATED_ARRAY, 5);
		assertEquals(1, idx);
	}
	@Test
	public void testFirstHalfEnd() {
		int idx = problem().search(ROTATED_ARRAY, 7);
		assertEquals(3, idx);
	}
	@Test
	public void testFirstHalfStart() {
		int idx = problem().search(ROTATED_ARRAY, 4);
		assertEquals(0, idx);
	}

	@Test
	public void testSecondHalfMiddleNoWrap() {
		int idx = problem().search(NOT_ROTATED_ARRAY, 1);
		assertEquals(1, idx);
	}
	@Test
	public void testSecondHalfEndNoWrap() {
		int idx = problem().search(NOT_ROTATED_ARRAY, 2);
		assertEquals(2, idx);
	}
	@Test
	public void testSecondHalfStartNoWrap() {
		int idx = problem().search(NOT_ROTATED_ARRAY, 0);
		assertEquals(0, idx);
	}

	@Test
	public void testFirstHalfMiddleNoWrap() {
		int idx = problem().search(NOT_ROTATED_ARRAY, 5);
		assertEquals(4, idx);
	}
	@Test
	public void testFirstHalfEndNoWrap() {
		int idx = problem().search(NOT_ROTATED_ARRAY, 7);
		assertEquals(6, idx);
	}
	@Test
	public void testFirstHalfStartNoWrap() {
		int idx = problem().search(NOT_ROTATED_ARRAY, 4);
		assertEquals(3, idx);
	}
}
