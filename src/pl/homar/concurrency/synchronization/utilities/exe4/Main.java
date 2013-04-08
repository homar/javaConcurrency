package pl.homar.concurrency.synchronization.utilities.exe4;

import java.util.concurrent.CyclicBarrier;

public class Main {
	public static void main(String[] args){
		final int ROWS = 10000;
		final int NUMBERS = 1000;
		final int SEARCH = 5;
		final int PARTICIPANTS = 5;
		final int LINE_PARTICIPATN = 2000;
		
		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
		
		Results results = new Results(ROWS);
		
		Grouper grouper = new Grouper(results);
		
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);
		
		Searcher searchers[] = new Searcher[PARTICIPANTS];
		for(int i = 0; i < PARTICIPANTS; i++){
			searchers[i] = new Searcher(i*LINE_PARTICIPATN, (i*LINE_PARTICIPATN) + LINE_PARTICIPATN, mock, results, 5, barrier);
			Thread t = new Thread(searchers[i]);
			t.start();
		}
		System.out.print("Main: finished\n");
	}
}
