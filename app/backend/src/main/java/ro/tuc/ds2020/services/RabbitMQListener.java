package ro.tuc.ds2020.services;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

import ro.tuc.ds2020.messages.ProcessConsumedMessage;

@Service
public class RabbitMQListener implements MessageListener {

	public void onMessage(Message message) {
		
		String consumedMsg=new String(message.getBody());
		System.out.println("Consuming Message - " + consumedMsg);
		ProcessConsumedMessage.process(consumedMsg);
		
	}

}