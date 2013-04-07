package pl.homar.concurrency.basic.synchronization.exe3;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventStorage storage = new EventStorage();
		Producer producer = new Producer(storage);
		Thread prodThread = new Thread(producer);
		Consumer consumer = new Consumer(storage);
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
		prodThread.start();
	}

}
