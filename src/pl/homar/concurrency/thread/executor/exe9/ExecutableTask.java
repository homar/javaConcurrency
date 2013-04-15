package pl.homar.concurrency.thread.executor.exe9;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExecutableTask implements Callable<String> {

	private String name;
	
	public ExecutableTask(String name) {
		super();
		this.setName(name);
	}

	@Override
	public String call() throws Exception {
		try{
			long duration = (long)(Math.random()*10);
			System.out.printf("%s waiting %d seconds for results\n", this.name, duration);
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		return "Hello world " + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
