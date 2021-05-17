package com.jmspractice.jmspractice.receiver;

import com.jmspractice.jmspractice.config.JmsConfig;
import com.jmspractice.jmspractice.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HelloWorldReceiver {

    @JmsListener(destination = JmsConfig.QUEUE)
    public void receiver(@Payload final HelloWorldMessage senderMessage) {
        final String message = senderMessage.getMessage();
        final UUID uuid = senderMessage.getUuid();

        System.out.println("Message received:" + message + ", UUID:" + uuid);
    }

}
