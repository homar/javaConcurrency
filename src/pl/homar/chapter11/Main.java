package pl.homar.chapter11;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThreadGroup threadGroup = new MyThreadGroup("My thread group" );
		Task task = new Task();
		for(int i = 0; i < 2; i ++){
			Thread t = new Thread(threadGroup, task);
			t.start();
		}
	}

}
