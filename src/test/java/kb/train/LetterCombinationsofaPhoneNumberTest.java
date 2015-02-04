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
public class LetterCombinationsofaPhoneNumberTest extends AbstractProblemTest<LetterCombinationsofaPhoneNumber>{

	public LetterCombinationsofaPhoneNumberTest() {
		super(LetterCombinationsofaPhoneNumber.class);
	}

	@Test
	public void test1() {
		List<String> result = problem().letterCombinations("23");
		Assert.assertEquals(9, result.size());
	}
	@Test
	public void test2() {
		List<String> result = problem().letterCombinations("7");
		Assert.assertEquals(4, result.size());
	}
	@Test
	public void test3() {
		List<String> result = problem().letterCombinations("234");
		Assert.assertEquals(27, result.size());
	}
}
