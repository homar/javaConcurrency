package pl.homar.concurrency.customizing.classes.exe7;

import java.util.concurrent.ForkJoinPool;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		int array[] = new int[10000];
		
		ForkJoinPool pool = new ForkJoinPool();
		Task task = new Task("Task", array, 0, array.length);
		
		pool.invoke(task);
		
		pool.shutdown();
		
		System.out.printf("Main: End of the program\n");
	}

}
