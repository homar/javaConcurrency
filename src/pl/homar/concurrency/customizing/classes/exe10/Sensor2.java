package pl.homar.concurrency.customizing.classes.exe10;

public class Sensor2 implements Runnable {

	private ParkingCounter counter;
	
	public Sensor2(ParkingCounter counter) {
		super();
		this.counter = counter;
	}

	@Override
	public void run() {
		counter.carIn();
		counter.carOut();
		counter.carOut();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carIn();
	}

}
