/**
 * 
 */
package kb.train.mt.perf;

import org.junit.Test;

/**
 * @author dmitry.paramzin
 *
 */
public class PerformanceTest {
	private static final int NUM_CALLS = 100000000;
	
	private SyncVsVolVsAtomic code = new SyncVsVolVsAtomic();
	
	@Test
	public void test1 () {
		new PerformanceMeter("atomic", NUM_CALLS, new Runnable() {
			public void run() {
				code.atomic();
			}
		}).execute();
	
		new PerformanceMeter("sync", NUM_CALLS, new Runnable() {
			public void run() {
				code.synchr();
			}
		}).execute();
		
		new PerformanceMeter("vol", NUM_CALLS, new Runnable() {
			public void run() {
				code.vol();
			}
		}).execute();
	}

}
