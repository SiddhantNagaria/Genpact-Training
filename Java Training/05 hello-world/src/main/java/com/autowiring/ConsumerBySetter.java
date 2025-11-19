package com.autowiring;

public class ConsumerBySetter {

	private MessageService messageService;

	// setter method - autowiring - byName, byType - then its method will be called
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public void run() {
		System.out.println("customer by setter ->" + 
	((messageService == null)? "no service " : messageService.sendMessage()));
	}
	
	
}
