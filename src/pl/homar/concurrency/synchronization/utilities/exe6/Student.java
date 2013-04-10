package pl.homar.concurrency.synchronization.utilities.exe6;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable {

	private Phaser phaser;
	
	public Student(Phaser phaser) {
		this.phaser = phaser;
	}

	@Override
	public void run() {
		System.out.printf("%s: has arrived to do the exam %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%s is going to do the first exercise%s\n", Thread.currentThread().getName(), new Date());
		doExercise1();
		System.out.printf("%s has done the first exercise %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%s is going to do the second exercise%s\n", Thread.currentThread().getName(), new Date());
		doExercise2();
		System.out.printf("%s has done the second exercise %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%s is going to do the third exercise%s\n", Thread.currentThread().getName(), new Date());
		doExercise3();
		System.out.printf("%s has done the third exercise %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%s has done finished the exam %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();		
	}
	
	private void doExercise1(){
		try{
			long duration = (long) (Math.random()*10);
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	private void doExercise2(){
		try{
			long duration = (long) (Math.random()*10);
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	private void doExercise3(){
		try{
			long duration = (long) (Math.random()*10);
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
