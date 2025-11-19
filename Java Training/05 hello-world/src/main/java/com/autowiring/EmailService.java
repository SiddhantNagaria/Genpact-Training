package com.autowiring;

public class EmailService implements MessageService {

	public String sendMessage() {
		return "Email sent";
	}

}
