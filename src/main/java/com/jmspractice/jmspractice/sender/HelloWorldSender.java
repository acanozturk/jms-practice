package com.jmspractice.jmspractice.sender;

import com.jmspractice.jmspractice.config.JmsConfig;
import com.jmspractice.jmspractice.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloWorldSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sender() {
        final HelloWorldMessage message = HelloWorldMessage
                .builder()
                .uuid(UUID.randomUUID())
                .message("Hello world.")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.QUEUE, message);

        System.out.println("Message sent");
    }

}
