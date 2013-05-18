package pl.homar.concurrency.customizing.classes.exe8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyQueuedSynchronizer extends AbstractQueuedSynchronizer {

	private AtomicInteger state;

	public MyQueuedSynchronizer() {
		super();
		this.state = new AtomicInteger(0);
	}
	
	@Override
	protected boolean tryAcquire(int arg){
		return state.compareAndSet(0, 1);
	}
	
	@Override
	protected boolean tryRelease(int arg){
		return state.compareAndSet(1, 0);
	}
	
}
