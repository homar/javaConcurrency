package pl.homar.concurrency.thread.executor.exe5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();
		
		List<Task> taskList = new ArrayList<Task>();
		for(Integer i = 0; i < 3; i++){
			Task task = new Task(i.toString());
			taskList.add(task);
		}
		List<Future<Result>> resultList = null;
		try{
			resultList = executor.invokeAll(taskList);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.printf("Main: Printing the results\n");
		for(int i =0; i < resultList.size(); i++){
			Future<Result> future = resultList.get(i);
			try{
				Result result = future.get();
				System.out.printf("%s %d\n", result.getName(), result.getValue());
			}catch(InterruptedException | ExecutionException e){
				e.printStackTrace();
			}
		}
	}

}
