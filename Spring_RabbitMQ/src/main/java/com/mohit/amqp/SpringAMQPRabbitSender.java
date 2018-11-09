package com.mohit.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAMQPRabbitSender {
    private final static String SENDER_XML = "springamqp-rabbit-sender-context.xml";
    public static void main(String[] args) throws Exception {
      AmqpTemplate amqpTemplate = (AmqpTemplate)(new ClassPathXmlApplicationContext(SENDER_XML)).getBean("amqpTemplate");
      int messagCount = 0;
	  while (messagCount < 10){
	    amqpTemplate.convertAndSend("12345", "Message # " + messagCount++);
	  }
	  System.out.println( messagCount + " message(s) sent successfully.");
	}
}
