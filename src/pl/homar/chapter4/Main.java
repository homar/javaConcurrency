package pl.homar.chapter4;

import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileSearch searcher = new FileSearch("C:\\", "test.input");
		Thread thread = new Thread(searcher);
		thread.start();
		try{
			TimeUnit.SECONDS.sleep(10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		thread.interrupt();
	}

}
