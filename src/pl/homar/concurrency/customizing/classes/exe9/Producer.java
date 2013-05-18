package pl.homar.concurrency.customizing.classes.exe9;

public class Producer implements Runnable {

	private MyPriorityTransferQueue<Event> buffer;
	
	public Producer(MyPriorityTransferQueue<Event> buffer) {
		super();
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for(int i = 0; i < 100; i++){
			Event event = new Event(Thread.currentThread().getName(), i);
			buffer.put(event);
		}
	}

}
