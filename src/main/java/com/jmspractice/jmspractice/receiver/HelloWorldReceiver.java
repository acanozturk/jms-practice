package com.jmspractice.jmspractice.receiver;

import com.jmspractice.jmspractice.config.JmsConfig;
import com.jmspractice.jmspractice.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldReceiver {

    @JmsListener(destination = JmsConfig.QUEUE)
    public void receiver(@Payload final HelloWorldMessage senderMessage) {
        System.out.println("Message received: " + senderMessage);
    }

}
