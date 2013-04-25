package pl.homar.concurrency.concurrent.collection.exe8;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Incrementer implements Runnable {

	private AtomicIntegerArray vector;
	
	@Override
	public void run() {
		for(int i = 0; i < vector.length(); i++){
			vector.getAndIncrement(i);
		}
	}

	public Incrementer(AtomicIntegerArray vector) {
		super();
		this.vector = vector;
	}

}
