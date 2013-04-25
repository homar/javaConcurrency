package pl.homar.concurrency.concurrent.collection.exe6;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread threads[] = new Thread[3];
		for(int i = 0; i < 3; i++){
			TaskLocalRandom task = new TaskLocalRandom();
			threads[i] = new Thread(task);
			threads[i].start();
		}
	}

}
