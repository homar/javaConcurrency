package pl.homar.concurrency.customizing.classes.exe9;

import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		MyPriorityTransferQueue<Event> buffer = new MyPriorityTransferQueue<Event>();
		
		Producer producer = new Producer(buffer);
		
		Thread producerThreads[] = new Thread[10];
		for(int i = 0; i < 10; i++){
			producerThreads[i] = new Thread(producer);
			producerThreads[i].start();
		}
		
		Consumer consumer = new Consumer(buffer);
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
		
		System.out.printf("Main: Buffer: Consumer count: %d\n", buffer.getWaitingConsumerCount());
		
		Event myEvent = new Event("Core Event", 0);
		buffer.transfer(myEvent);
		System.out.printf("MyEvent has been transfered\n");
		
		for(int i = 0; i < producerThreads.length; i++){
			try{
				producerThreads[i].join();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		TimeUnit.SECONDS.sleep(1);
		
		System.out.printf("Main: Buffer: Consumer count: %d\n", buffer.getWaitingConsumerCount());
		
		myEvent = new Event("Core Event 2", 0);
		buffer.transfer(myEvent);
		
		consumerThread.join();
		
		System.out.printf("Main: End of the program\n");
	}

}
