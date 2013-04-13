package pl.homar.concurrency.thread.executor.exe4;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {

	private UserValidator validator;
	private String user;
	private String password;
	
	public TaskValidator(UserValidator validator, String user, String password) {
		super();
		this.validator = validator;
		this.user = user;
		this.password = password;
	}

	@Override
	public String call() throws Exception {
		if(validator.validate(user, password)){
			System.out.printf("%s The user has not been found\n", validator.getName());
			throw new Exception("Error validating user");
		}
		System.out.printf("%s The used has beem found\n", validator.getName());
		return validator.getName();
	}

}
