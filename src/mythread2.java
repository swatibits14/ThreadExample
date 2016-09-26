class Callme {
	 void call(String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(100);
			System.out.println(msg);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	String msg;
	Callme target;
	Thread t;

	public Caller(Callme targ, String s) {
		target = targ;
		msg = s;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		synchronized (target) {
			target.call(msg);
		}
		
	}
}

class mythread2 {
	public static void main(String args[]) {
		Callme target = new Callme();
		Caller ob1 = new Caller(target, "World");
		Caller ob2 = new Caller(target, "Syn");
		Caller ob3 = new Caller(target, "Yelo");
		Caller ob4 = new Caller(target, "wlo");
		Caller ob5 = new Caller(target, "klo");
		// wait for threads to end
		try {
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
			ob4.t.join();
			ob5.t.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
}
