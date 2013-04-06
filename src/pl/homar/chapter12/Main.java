package pl.homar.chapter12;

import javax.xml.parsers.FactoryConfigurationError;

public class Main {

	public static void main(String[] args){
		MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();
		Thread thread;
		for(int i =0; i < 10; i++){
			thread = myThreadFactory.newThread(task);
			thread.start();
		}
		System.out.printf("Factory stats:\n");
		System.out.printf("%s\n", myThreadFactory.getStats());
	}
}
