/**
 * 
 */
package kb.train.mt.perf;

/**
 * @author dmitry.paramzin
 *
 */
public class PerformanceMeter {
	private final Runnable r;
	private String name;
	private int numCalls;
	
	public PerformanceMeter(String name, int numCalls, Runnable r) {
		this.name = name;
		this.r = r;
		this.numCalls = numCalls;
	}

	public void execute() {
		long start = System.currentTimeMillis();
		for(int i = 0;i < numCalls; i++) {
			try {
				r.run();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + ":" + (System.currentTimeMillis()-start));
	}
}
