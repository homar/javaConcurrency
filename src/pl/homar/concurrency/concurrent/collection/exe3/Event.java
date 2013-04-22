package pl.homar.concurrency.concurrent.collection.exe3;

public class Event implements Comparable<Event> {

	private int thread;
	private int priority;
	
	public Event(int thread, int priority) {
		super();
		this.setThread(thread);
		this.setPriority(priority);
	}

	@Override
	public int compareTo(Event e) {
		if(this.priority > e.getPriority()){
			return -1;
		}else if(this.priority < e.getPriority()){
			return 1;
		}else{
			return 0;
		}
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getThread() {
		return thread;
	}

	public void setThread(int thread) {
		this.thread = thread;
	}

}
