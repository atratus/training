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
public class GenerateParenthesesTest extends AbstractProblemTest<GenerateParentheses> {

	public GenerateParenthesesTest() {
		super(GenerateParentheses.class);
	}

	@Test
	public void test1() {
		List<String> result = problem().generateParenthesis(3);
		Assert.assertEquals(5, result.size());
	}
}
