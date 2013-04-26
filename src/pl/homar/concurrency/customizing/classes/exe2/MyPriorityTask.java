package pl.homar.concurrency.customizing.classes.exe2;

import java.util.concurrent.TimeUnit;

public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {

	private int priority;
	private String name;
	
	public MyPriorityTask(int priority, String name) {
		super();
		this.setPriority(priority);
		this.setName(name);
	}

	@Override
	public int compareTo(MyPriorityTask o) {
		if(this.getPriority() > o.getPriority()){
			return 1;
		}else if(o.getPriority() > this.getPriority()){
			return -1;
		}
		return 0;
	}

	@Override
	public void run() {
		System.out.printf("MyPriorityTask: %s Priority : %d\n", name, priority);
		try{
			TimeUnit.SECONDS.sleep(2);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
