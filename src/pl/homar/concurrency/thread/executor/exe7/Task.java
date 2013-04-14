package pl.homar.concurrency.thread.executor.exe7;

import java.util.Date;

public class Task implements Runnable {

	private String name;
	
	public Task(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("%s Starting at %s\n", name, new Date());
	}

}
