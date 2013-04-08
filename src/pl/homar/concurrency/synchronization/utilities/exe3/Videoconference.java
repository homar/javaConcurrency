package pl.homar.concurrency.synchronization.utilities.exe3;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {

	private final CountDownLatch controller;
	
	public Videoconference(int number){
		controller = new CountDownLatch(number);
	}
	
	public void arrive(String name){
		System.out.printf("%s has arrived\n", name);
		controller.countDown();
		System.out.printf("VideoConference: Waitin for %d participants\n", controller.getCount());
	}
	
	@Override
	public void run() {
		System.out.printf("VideoConference: Initialization: %d participants\n.", controller.getCount());
		try{
			controller.await();
			System.out.printf("VideoConferece: All the participants have arrived\n Lets start \n");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
