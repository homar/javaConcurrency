package pl.homar.concurrency.basic.synchronization.exe7;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileMock mock = new FileMock(100,10);
		Buffer buffer = new Buffer(20);
		Producer producer = new Producer(mock, buffer);
		Thread prodThread = new Thread(producer, "Producer");
		
		Consumer consumers[] = new Consumer[3];
		Thread consumerThreads[] = new Thread[3];
		
		for(int i = 0; i < 3; i++){
			consumers[i] = new Consumer(buffer);
			consumerThreads[i] = new Thread(consumers[i], "Consumer" + i);
		}
		
		prodThread.start();
		for(int i = 0; i < 3; i++){
			consumerThreads[i].start();
		}
	}

}
