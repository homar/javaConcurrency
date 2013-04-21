package pl.homar.concurrency.fork.join.exe5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

public class TaskManager {
	private List<ForkJoinTask<Integer>> tasks;
	
	public TaskManager(){
		tasks = new ArrayList<ForkJoinTask<Integer>>();
	}
	
	public void addTask(ForkJoinTask<Integer> task){
		tasks.add(task);
	}
	
	public void cancelTask(ForkJoinTask<Integer> cancelTask){
		for(ForkJoinTask<Integer> task : tasks){
			if(task!=cancelTask){
				task.cancel(true);
				((SearchNumberTask)task).writeCancelMessage();
			}
		}
	}
}
