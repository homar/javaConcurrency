package pl.homar.concurrency.basic.synchronization.exe1;

public class Account {
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public synchronized void addAmout(double amount){
		double tmp = balance;
		try{
			Thread.sleep(10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		tmp += amount;
		balance = tmp;
	}
	
	public synchronized void subtractamount(double amount){
		double tmp = balance;
		try{
			Thread.sleep(10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		tmp -= amount;
		balance = tmp;
	}
	
}
