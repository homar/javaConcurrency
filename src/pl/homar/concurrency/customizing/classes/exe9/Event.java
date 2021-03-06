package pl.homar.concurrency.customizing.classes.exe9;

public class Event implements Comparable<Event> {

	private String thread;
	private int priority;
	
	public Event(String thread, int priority) {
		super();
		this.thread = thread;
		this.priority = priority;
	}

	public String getThread(){
		return thread;
	}
	
	public int getPriority(){
		return priority;
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

}
