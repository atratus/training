/**
 * 
 */
package kb.train;

import java.util.ArrayList;

import kb.train.bean.ListNode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dmitry.paramzin
 *
 */
public class MergekSortedListsTest extends AbstractProblemTest<MergekSortedLists>{

	class ListsBuilder {
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		ListsBuilder list(int... values) {
			ListNode root = null;
			for(int i = values.length-1; i >= 0; i--) {
				ListNode newNode = new ListNode(values[i], root);
				root = newNode;
			}
			lists.add(root);
			return this;
		}
		ArrayList<ListNode> build() {
			return lists;
		}
	}
	public MergekSortedListsTest() {
		super(MergekSortedLists.class);
	}
	
	@Test
	public void test1() {
		ListNode merged = problem().mergeKLists(new ListsBuilder().list(1,2,3).list(4,6,7).build());
		Assert.assertEquals(1, merged.val);
		Assert.assertEquals(7, merged.next.next.next.next.next.val);
		Assert.assertNull(merged.next.next.next.next.next.next);
	}
	@Test
	public void test2() {
		ListNode merged = problem().mergeKLists(new ListsBuilder().list(1,2).list(4,6,7).build());
		Assert.assertEquals(1, merged.val);
		Assert.assertEquals(7, merged.next.next.next.next.val);
		Assert.assertNull(merged.next.next.next.next.next);
	}
	@Test
	public void test3() {
		ListNode merged = problem().mergeKLists(new ListsBuilder().list(1,2,3).list(4,6).build());
		Assert.assertEquals(1, merged.val);
		Assert.assertEquals(6, merged.next.next.next.next.val);
		Assert.assertNull(merged.next.next.next.next.next);
	}
	@Test
	public void test4() {
		ListNode merged = problem().mergeKLists(new ListsBuilder().list(1,3,6).list(2,10).build());
		Assert.assertEquals(1, merged.val);
		Assert.assertEquals(10, merged.next.next.next.next.val);
		Assert.assertNull(merged.next.next.next.next.next);
	}
	@Test
	public void test5() {
		ListNode merged = problem().mergeKLists(new ListsBuilder().list(1,1,1).list(1,1).build());
		Assert.assertEquals(1, merged.val);
		Assert.assertEquals(1, merged.next.next.next.next.val);
		Assert.assertNull(merged.next.next.next.next.next);
	}
}
