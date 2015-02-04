/**
 * 
 */
package kb.train;

/**
 * @author dmitry.paramzin
 *
 */
public class AbstractProblemTest<C> {

	private Class<C> problemClass;
	
	public AbstractProblemTest(Class<C> problemClass) {
		this.problemClass = problemClass;
	}

	protected C problem() {
		try {
			return problemClass.newInstance();
		} catch (Exception e) {
			throw new  RuntimeException(e);
		}
	}
}
