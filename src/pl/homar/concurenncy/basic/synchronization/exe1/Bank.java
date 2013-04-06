package pl.homar.concurenncy.basic.synchronization.exe1;

public class Bank implements Runnable {
	private Account account;
	
	public Bank(Account account){
		this.account = account;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++){
			account.subtractamount(1000);
		}
	}

}
