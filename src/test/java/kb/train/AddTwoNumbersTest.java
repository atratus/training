/**
 * 
 */
package kb.train;

import kb.train.bean.ListNode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author black
 * @param <C>
 *
 */
public class AddTwoNumbersTest extends AbstractProblemTest<AddTwoNumbers> {

	public AddTwoNumbersTest() {
		super(AddTwoNumbers.class);
	}


	@Test
	public void test1() {
		ListNode res = problem().addTwoNumbers(nlist("342"), nlist("465"));
		Assert.assertEquals("807", toString(res));
	}
	@Test
	public void test2() {
		ListNode res = problem().addTwoNumbers(nlist("24"), nlist("564"));
		Assert.assertEquals("588", toString(res));
	}
	@Test
	public void test3() {
		ListNode res = problem().addTwoNumbers(nlist("5"), nlist("5"));
		Assert.assertEquals("10", toString(res));
	}

	private String toString(ListNode list) {
		StringBuilder sb = new StringBuilder();
		
		ListNode next = list;
		while(next != null) {
			sb.append(Integer.toString(next.val));
			next = next.next;
		}
		return sb.reverse().toString();
	}


	private ListNode nlist(String num) {
		///num = new StringBuilder(num).reverse().toString();
		ListNode root = null;
		for(int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			ListNode n = new ListNode(Integer.parseInt(String.valueOf(c)));
			n.next = root;
			root = n;
		}
		return root;
	}
}
