package pl.homar.chapter3;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread task = new PrimeGenerator();
		task.start();
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		task.interrupt();
	}

}
