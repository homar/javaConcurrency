package pl.homar.concurrency.thread.executor.exe8;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		
		Task task = new Task();
		System.out.printf("Main executirng new task\n");
		Future<String> result = executor.submit(task);
		try{
			TimeUnit.SECONDS.sleep(2);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.printf("Main canceling the task\n");
		result.cancel(true);
		System.out.printf("Main canceled: %s, args\n", result.isCancelled());
		System.out.printf("Main DONE: %s, args\n", result.isDone());
		executor.shutdown();
		System.out.printf("Main the executor has finished\n");
	}

}
