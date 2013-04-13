package pl.homar.concurrency.thread.executor.exe3;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {

	private Integer number;
	
	public FactorialCalculator(Integer number) {
		super();
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {
		int result = 1;
		if((number == 0) || (number == 1)){
			return 1;
		}
		for(int i = 2; i <= number; i++){
			result *= i;
			TimeUnit.MILLISECONDS.sleep(20);
		}
		System.out.printf("%s: %dn\n", Thread.currentThread().getName(), result);
		return result;
	}

}
