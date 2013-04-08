package pl.homar.concurrency.synchronization.utilities.exe3;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {

	private Videoconference conference;
	private String name;
	
	
	public Participant(Videoconference conference, String name) {
		this.conference = conference;
		this.name = name;
	}


	@Override
	public void run() {		
		long duration = (long) (Math.random()*10);
		System.out.printf("sleeping for %d \n", duration);
		try{
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		conference.arrive(name);
	}

}
