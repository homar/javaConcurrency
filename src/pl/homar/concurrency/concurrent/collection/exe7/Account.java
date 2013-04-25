package pl.homar.concurrency.concurrent.collection.exe7;

import java.util.concurrent.atomic.AtomicLong;

public class Account {

	private AtomicLong balance;

	public Account() {
		super();
		this.balance = new AtomicLong();
	}

	public long getBalance() {
		return balance.get();
	}

	public void setBalance(long balance) {
		this.balance.set(balance);
	}
	
	public void addAmount(long amount){
		this.balance.getAndAdd(amount);
	}
	
	public void suntractAmount(long amount){
		this.balance.getAndAdd(-amount);
	}
	
}
