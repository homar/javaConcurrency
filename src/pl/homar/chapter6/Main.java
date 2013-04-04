package pl.homar.chapter6;

import java.util.Date;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataSourceLoader dataSourceLoader = new DataSourceLoader();
		Thread dataSourcesLoaderThread = new Thread(dataSourceLoader, "DataSourcesLoaderThread");
		NetworkConnectionsLoader networkConnectionsLoader = new NetworkConnectionsLoader();
		Thread networkConnectionsLoaderThread = new Thread(networkConnectionsLoader, "NetworkConnectionsLoaderThread");
		dataSourcesLoaderThread.start();
		networkConnectionsLoaderThread.start();	
		try{
			dataSourcesLoaderThread.join();
			networkConnectionsLoaderThread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
	}

}
