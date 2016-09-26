class clicker implements Runnable {
	long click = 0;
	Thread t;
	private volatile boolean running = true;

	public clicker(int p) {
		t = new Thread(this);
		t.setPriority(p);
	}

	public void run() {
		while (running) {
			System.out.println(click+t.getName().toString());
			click++;
		}
	}

	public void stop() {
		running = false;
	}

	public void start() {
		t.start();
	}
}

class mythread1 {
	public static void main(String args[]) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		clicker morehi = new clicker(Thread.NORM_PRIORITY+2);
		clicker hi = new clicker(Thread.NORM_PRIORITY + 2);
		clicker lo = new clicker(Thread.NORM_PRIORITY - 2);
		lo.start();
		hi.start();
		morehi.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		lo.stop();
		hi.stop();
		morehi.stop();
		// Wait for child threads to terminate.
		try {
			morehi.t.join();
			hi.t.join();
			lo.t.join();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
		System.out.println("Low-priority thread: " + lo.click);
		System.out.println("High-priority thread: " + hi.click);
		System.out.println("High-priority thread: " + morehi.click);
	}
}
