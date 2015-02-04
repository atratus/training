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
public class RemoveNthNodeFromEndofListTest extends AbstractProblemTest<RemoveNthNodeFromEndofList> {

	public RemoveNthNodeFromEndofListTest() {
		super(RemoveNthNodeFromEndofList.class);
	}

	@Test
	public void test1() {
		ListNode res = problem().removeNthFromEnd(new ListNode(1,
				new ListNode(2,
						new ListNode(3,
								new ListNode(4,
										new ListNode(5))))), 2);
		Assert.assertNull(res.next.next.next.next);
		Assert.assertEquals(5, res.next.next.next.val);
	}
	
	@Test
	public void test2() {
		ListNode res = problem().removeNthFromEnd(new ListNode(1,
				new ListNode(2,
						new ListNode(3,
								new ListNode(4,
										new ListNode(5))))), 5);
		Assert.assertNull(res.next.next.next.next);
		Assert.assertEquals(2, res.val);
	}
	@Test
	public void test3() {
		ListNode res = problem().removeNthFromEnd(new ListNode(1,
				new ListNode(2,
						new ListNode(3,
								new ListNode(4,
										new ListNode(5))))), 1);
		Assert.assertNull(res.next.next.next.next);
		Assert.assertEquals(4, res.next.next.next.val);
	}
	@Test
	public void test4() {
		ListNode res = problem().removeNthFromEnd(new ListNode(1,
				new ListNode(2,
						new ListNode(3,
								new ListNode(4,
										new ListNode(5))))), 10);
		Assert.assertNull(res.next.next.next.next.next);
		Assert.assertEquals(5, res.next.next.next.next.val);
	}
}
