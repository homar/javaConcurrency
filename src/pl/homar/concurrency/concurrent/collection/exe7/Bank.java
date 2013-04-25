package pl.homar.concurrency.concurrent.collection.exe7;

public class Bank implements Runnable {

	private Account account;
	
	public Bank(Account account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i ++){
			account.suntractAmount(1000);
		}
	}

}
