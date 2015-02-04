/**
 * 
 */
package kb.train.mt.perf;

import org.junit.Test;

/**
 * @author dmitry.paramzin
 *
 */
public class DeadlockTest {

	@Test
	public void deadlockTest() {
		final Object r1 = new Object();
		final Object r2 = new Object();
		final Object r3 = new Object();
		
	
		final Thread t1 = new Thread() {

			@Override
			public void run() {
				synchronized (r1) {
					System.out.println("t1 - before deadlock");
					synchronized (r2) {
						System.out.println("t1");
					}
				};
				System.out.println("t1 - SHOULD NEVER HAPPEN");
			}
			
		};
		//t1.setDaemon(true);
		
		final Thread t2 = new Thread() {

			@Override
			public void run() {
				synchronized (r2) {
					t1.start();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t2 - before deadlock");
					synchronized (r3) {
						System.out.println("t2");
						
					}
					System.out.println("t2 - SHOULD NEVER HAPPEN");
				};
			}
		};

		Thread t3 = new Thread() {

			@Override
			public void run() {
				synchronized (r3) {
					t2.start();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t3 - before deadlock");
					synchronized (r1) {
						System.out.println("t2");
						
					}
					System.out.println("t3 - SHOULD NEVER HAPPEN");
				};
			}
		};
		t3.start();

		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
