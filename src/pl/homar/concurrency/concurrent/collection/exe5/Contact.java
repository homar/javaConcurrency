package pl.homar.concurrency.concurrent.collection.exe5;

public class Contact {
	private String name;
	private String phone;
	
	public Contact(String name, String phone) {
		super();
		this.setName(name);
		this.setPhone(phone);
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
