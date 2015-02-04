/**
 * 
 */
package kb.train.mt.perf;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dmitry.paramzin
 *
 */
public class SyncVsVolVsAtomic {
	Random random = new Random();

	int a;
	volatile int b;
	AtomicInteger c = new AtomicInteger();
	
	public synchronized void synchr () {
		a = random.nextInt();
	}

	public void vol () {
		b = random.nextInt();
	}

	public void atomic () {
		c.set(random.nextInt());
	}
}
