package pl.homar.concurrency.synchronization.utilities.exe3;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Videoconference conference = new Videoconference(10);
		Thread conferenceThread = new Thread(conference);
		conferenceThread.start();
		
		for(int i =0; i < 10; i++){
			Participant p = new Participant(conference, "Participant" + i);
			Thread t = new Thread(p);
			t.start();
		}
	}

}
