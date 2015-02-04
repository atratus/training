/**
 * 
 */
package kb.train;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dmitry.paramzin
 */
public class MedianofTwoSortedArraysTest extends AbstractProblemTest<MedianofTwoSortedArrays> {

	public MedianofTwoSortedArraysTest() {
		super(MedianofTwoSortedArrays.class);
	}

	@Test
	public void test1() {
		double median = problem().findMedianSortedArrays(new int[]{1,2,4}, new int[]{1, 3, 4});
		assertMedian(2.5, median);
	}
	
	@Test
	public void test2() {
		double median = problem().findMedianSortedArrays(new int[]{1,3,4}, new int[]{5, 6, 7});
		assertMedian(4.5, median);
	}
	@Test
	public void test3() {
		double median = problem().findMedianSortedArrays(new int[]{1,3,4}, new int[]{1, 2});//1, 1,2,3,4 -> 2
		assertMedian(2, median);
	}
	@Test
	public void test4() {
		double median = problem().findMedianSortedArrays(new int[]{1,3,4,6, 10}, new int[]{0, 2});//0, 1,2, 3, 4,6,10 -> 3
		assertMedian(3, median);
	}
	@Test
	public void test5() {
		double median = problem().findMedianSortedArrays(new int[]{1,1,3,3}, new int[]{1,1,3,3});//1,1,1,1, 3,3,3,3 -> 2
		assertMedian(2, median);
	}
	@Test
	public void test6() {
		double median = problem().findMedianSortedArrays(new int[]{100001}, new int[]{100000});//100000.5
		assertMedian(100000.5, median);
	}
	@Test
	public void test7() {
		double median = problem().findMedianSortedArrays(new int[]{1, 2}, new int[]{4, 6, 7});//1,2,4,6,7->4
		assertMedian(4, median);
	}
 	
	@Test
	public void test8() {
		double median = problem().findMedianSortedArrays(new int[]{1}, new int[]{2,3,4});//1,2,3,4->2.5
		assertMedian(2.5, median);
	}
 	
	@Test
	public void test9() {
		double median = problem().findMedianSortedArrays(new int[]{1,2}, new int[]{1,2});//1,1,2,2 ->1.5
		assertMedian(1.5, median);
	}
	 	
	@Test
	public void test10() {
		double median = problem().findMedianSortedArrays(new int[]{1,3}, new int[]{2,4});//1,2,3,4 ->2.5
		assertMedian(2.5, median);
	}

	@Test
	public void test11() {
		double median = problem().findMedianSortedArrays(new int[]{3}, new int[]{1,2});//1,2,3 ->2
		assertMedian(2, median);
	}
	@Test
	public void test12() {
		double median = problem().findMedianSortedArrays(new int[]{1,4}, new int[]{2,3});//1,2,3,4 ->2.5
		assertMedian(2.5, median);
	}
	@Test
	public void test13() {
		double median = problem().findMedianSortedArrays(new int[]{1,4,5}, new int[]{2,3,6});//1,2,3,4,5,6 ->3.5
		assertMedian(3.5, median);
	}
	@Test
	public void test14() {
		double median = problem().findMedianSortedArrays(new int[]{1,2,3}, new int[]{4,5,6,7});//1,2,3,4,5,6,7 ->4
		assertMedian(4, median);
	}
	
	@Test
	public void test15() {
		double median = problem().findMedianSortedArrays(new int[]{1,3,7,8}, new int[]{2,4,5,6});//1,2,3,4,5,6,7,8 ->4.5
		assertMedian(4.5, median);
	}
	
	@Test
	public void test16() {
		double median = problem().findMedianSortedArrays(new int[]{1,2,3,4}, new int[]{5,6,7,8});//1,2,3,4,5,6,7,8 ->4.5
		assertMedian(4.5, median);
	}
 	
	private void assertMedian(double expected, double actual) {
		Assert.assertTrue("median should be " + expected + " but was:" + actual,
				actual+0.0001 > expected && actual-0.0001 < expected);
	}

}
