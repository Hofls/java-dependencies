package hello;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@JmsListener(destination = "purchase-topic", containerFactory = "mainFactory")
	public void receiveMessage(Purchase purchase) {
		System.out.println("Received message - " + purchase);
	}

}
