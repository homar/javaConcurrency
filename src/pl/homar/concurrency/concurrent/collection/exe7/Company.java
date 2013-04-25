package pl.homar.concurrency.concurrent.collection.exe7;

public class Company implements Runnable {

	private Account account;
	
	public Company(Account account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			account.addAmount(1000);
		}
	}

}
