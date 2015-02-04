/**
 * 
 */
package kb.train.fp;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author dmitry.paramzin
 */
public class FloatingPointTest {
	@Test
	public void test0() {
		printparts(0.0f);
	}
	@Test
	public void test1() {
		printparts(1.0f);
	}
	@Test
	public void test2() {
		printparts(2.0f);
	}
	@Test
	public void test3() {
		printparts(3.0f);
	}

	private void printparts(float f) {
		int i = Float.floatToIntBits(f);
		
		System.out.println("original=" + f);
		System.out.println("bin=" + toBinaryString(i));
		
		int rawExp = getRawExp(i);
		int exp = getExp(i);
		int mant = getMantissa(i);
		System.out.println("raw exponent=" + (rawExp) + "/" + Integer.toBinaryString(rawExp));
		System.out.println("exponent=" + (exp));
		System.out.println("mantissa=" + (mant) + "/" + Integer.toBinaryString(mant));
		
		float r = reconstruct(mant, rawExp, false);
		System.out.println("reconstruct=" + r);
		
		Assert.assertEquals(f, r, 0.00000001);
	}
	
	private String toBinaryString(int val) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 23; i++) {
			sb.append((val & 1) == 1 ? '1' : '0');
			val >>= 1;
		}
		sb.append(' ');
		for(int i = 0; i < 7; i++) {
			sb.append((val & 1) == 1 ? '1' : '0');
			val >>= 1;
		}
		sb.append(' ');
		sb.append((val & 1) == 1 ? '1' : '0');
		return sb.reverse().toString();
	}
	private float reconstruct(int mant, int rawExp, boolean isNegative) {
		if(rawExp == 0) {
		    return 0;
		}
		float reconstructed = Math.scalb(mant, rawExp-127);
		if(isNegative) {
			reconstructed = -reconstructed;			
		}
		return reconstructed+1;
	}
	private int getMantissa(int i) {
		return i & 0x7FFFFF;
	}
	private int getRawExp(int i) {
		return (i >> 23) & 0x7F;
	}
	private int getExp(int i) {
		return getRawExp(i)-127;
	}
}
