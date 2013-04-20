package pl.homar.concurrency.thread.executor.exe3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
		Random random = new Random();
		for(int i = 0; i < 10; i++){
			Integer number = random.nextInt(10);
			FactorialCalculator calculator = new FactorialCalculator(number);
			Future<Integer> result = executor.submit(calculator);
			resultList.add(result);
		}
		do{
			System.out.printf("Main: Number of Completed Tasks: %d\n", executor.getCompletedTaskCount());
			for(int i = 0; i < 10; i++){
				Future<Integer> result = resultList.get(i);
				System.out.printf("Main: Task %d: %s\n", i, result.isDone());
			}
			try{
				TimeUnit.MILLISECONDS.sleep(50);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(executor.getCompletedTaskCount() < resultList.size());
		System.out.printf("Main: Results: \n");
		for(int i = 0; i < 10; i++){
			Future<Integer> result = resultList.get(i);
			Integer number = null;
			try{
				number = result.get();
			}catch(InterruptedException e){
				e.printStackTrace();
			}catch (ExecutionException e) {
				e.printStackTrace();
			}
			System.out.printf("Main: Task %d: %d\n",i , number);
		}
		executor.shutdown();
	}

}