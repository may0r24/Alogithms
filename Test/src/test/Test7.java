package test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test7 {

	private static ExecutorService executor = Executors.newFixedThreadPool(10);
	private static ExecutorService processExecutor = Executors.newFixedThreadPool(10);
	static Integer one, two, three, four, five, six, seven, eight, nine, ten;
	final static String ESC = "\033[";

	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		Future<?> a = calculate(200000, 1);
		Future<?> b = calculate(400000, 200000);
		Future<?> c = calculate(800000, 400000);
		Future<?> d = calculate(1200000, 1000000);
		Future<?> e = calculate(1400000, 1200000);
		Future<?> f = calculate(1600000, 1400000);
		Future<?> g = calculate(1800000, 1600000);
		Future<?> h = calculate(2000000, 1800000);
		Future<?> i = calculate(1000000, 800000);
		Future<?> j = calculate(600000, 400000);

//		while(!(a.isDone() && b.isDone() && c.isDone() && d.isDone() && e.isDone() && f.isDone() && g.isDone() && h.isDone()
//				&& i.isDone() && j.isDone())) {
		while(true) {
			if (!j.isDone()) {
				System.out.println("Processing 10 calculating...");		
			}
			if (!i.isDone()) {
				System.out.println("Processing 9 calculating...");	
			}
			if (!h.isDone()) {
				System.out.println("Processing 8 calculating...");
			}
			if (!g.isDone()) {
				System.out.println("Processing 7 calculating...");
			}
			if (!f.isDone()) {
				System.out.println("Processing 6 calculating...");
			}
			if (!e.isDone()) {
				System.out.println("Processing 5 calculating...");
			}
			if (!d.isDone()) {
				System.out.println("Processing 4 calculating...");
			}
			if (!c.isDone()) {
				System.out.println("Processing 3 calculating...");
			}
			if (!b.isDone()) {
				System.out.println("Processing 2 calculating...");
			}
			if (!a.isDone()) {
				System.out.println("Processing 1 calculating...");
			}
			System.out.println("---------------------------------------------------");
			if (a.isDone() && b.isDone() && c.isDone() && d.isDone() && e.isDone() && f.isDone() && g.isDone() && h.isDone()
					&& i.isDone() && j.isDone()) {
				break;
			}
		}

		if (a.isDone() && b.isDone() && c.isDone() && d.isDone() && e.isDone() && f.isDone() && g.isDone() && h.isDone()
				&& i.isDone() && j.isDone()) {
			System.out.println("Result of Process 1: " + a.get());
			System.out.println("Result of Process 2: " + b.get());
			System.out.println("Result of Process 3: " + c.get());
			System.out.println("Result of Process 4: " + d.get());
			System.out.println("Result of Process 5: " + e.get());
			System.out.println("Result of Process 6: " + f.get());
			System.out.println("Result of Process 7: " + g.get());
			System.out.println("Result of Process 8: " + h.get());
			System.out.println("Result of Process 9: " + i.get());
			System.out.println("Result of Process 10: " + j.get());
		}
	}

	private static Future<String> processTen(Future<?> j) {
		return processExecutor.submit(() -> {
			String res = null;
			while (!j.isDone()) {
				res = "Processing 10 calculating...";
				if (j.isDone()) {
					ten = (Integer) j.get();
				}
			}
			return res;
		});
	}

	private static Future<String> processNine(Future<?> i) {
		return processExecutor.submit(() -> {
			String res = null;
			while (!i.isDone()) {
				res = "Processing 9 calculating...";
				if (i.isDone()) {
					nine = (Integer) i.get();
				}
			}
			return res;
		});
	}

	private static Future<String> processEight(Future<?> h) {
		return processExecutor.submit(() -> {
			String res = null;
			while (!h.isDone()) {
				res = "Processing 8 calculating...";
				if (h.isDone()) {
					eight = (Integer) h.get();
				}
			}
			return res;
		});
	}

	private static Future<String> processSeven(Future<?> g) {
		return processExecutor.submit(() -> {
			String res = null;
			while (!g.isDone()) {
				res = "Processing 7 calculating...";
				if (g.isDone()) {
					seven = (Integer) g.get();
				}
			}
			return res;
		});
	}

	private static Future<String> processSix(Future<?> f) {
		return processExecutor.submit(() -> {
			String res = null;
			while (!f.isDone()) {
				res = "Processing 6 calculating...";
				if (f.isDone()) {
					six = (Integer) f.get();
				}
			}
			return res;
		});
	}

	private static Future<String> processFive(Future<?> e) {
		return processExecutor.submit(() -> {
			String res = null;
			while (!e.isDone()) {
				res = "Processing 5 calculating...";
				if (e.isDone()) {
					five = (Integer) e.get();
				}
			}
			return res;
		});
	}

	private static Future<String> processFour(Future<?> d) {
		return processExecutor.submit(() -> {
			String res = null;
			while (!d.isDone()) {
				res = "Processing 4 calculating...";
				if (d.isDone()) {
					four = (Integer) d.get();
				}
			}
			return res;
		});
	}

	private static Future<String> processThree(Future<?> c) {
		return processExecutor.submit(() -> {
			String res = null;
			while (!c.isDone()) {
				res = "Processing 3 calculating...";
				if (c.isDone()) {
					three = (Integer) c.get();
				}
			}
			return res;
		});
	}

	private static Future<String> processtwo(Future<?> b) {
		return processExecutor.submit(() -> {
			String res = null;
			while (!b.isDone()) {
				res = "Processing 2 calculating...";
				if (b.isDone()) {
					two = (Integer) b.get();
				}
			}
			return res;
		});
	}

	public static Integer getPrime(int limit, int start) {	
		Integer sum = 0;

		for (int i = start; i <= limit; i++) {
			int count = 0;
			for (int div = i; div >= 1; div--) {
				if (i % div == 0) {
					count += 1;
				}
			}
			if (count == 2) {
				sum += i;
			}
		}
		return sum;
	}

	public static Future<?> calculate(Integer limit, Integer start) {
		return executor.submit(() -> {
			getPrime(limit, start);
		});
	}

	private static Future<String> processOne(Future<?> a) throws InterruptedException, ExecutionException {
		return executor.submit(() -> {
			String res = null;
			while (!a.isDone()) {
				System.out.println("Processing 1 calculating...");
				if (a.isDone()) {
					one = (Integer) a.get();
				}
			}
			return res;
		});
	}
	
	public static void cls()
    {
        try 
        {
            Runtime.getRuntime().exec("cmd /c cls");
        }
        catch(final Exception e)
        {
            System.out.print(e);
        }

    }
}
