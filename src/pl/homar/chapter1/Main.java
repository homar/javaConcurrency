package pl.homar.chapter1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i =0; i <= 10; i++){
			Calculator calculator = new Calculator(i);
			Thread thread = new Thread(calculator);
			thread.start();
		}
	}

}
