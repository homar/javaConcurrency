package pl.homar.chapter8;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}

}
