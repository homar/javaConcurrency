package pl.homar.concurrency.thread.executor.exe9;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String> {
	
	public ResultTask(Callable<String> callable) {
		super(callable);
		this.name = ((ExecutableTask)callable).getName();
	}

	@Override
	protected void done(){
		if(isCancelled()){
			System.out.printf("%s has been canceled\n", name);
		}else{
			System.out.printf("%s has finished\n", name);
		}
	}
	
	private String name;
}
