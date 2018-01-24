package spring.jms.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

@Component
public class TopicPublisher {

    private final static Logger LOGGER = LoggerFactory.getLogger(TopicPublisher.class);

    private JmsOperations jmsOperations;

    @Autowired
    public TopicPublisher(@Qualifier("jmsTemplateTopic") JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    public void produce() throws InterruptedException {
        LOGGER.info("Publishing 10 messages...");
        for (int i = 1; i <= 10; i++) {
            LOGGER.info("Sending message: {}", i);
            jmsOperations.convertAndSend("Message topic: " + i);
            Thread.sleep(1000);
        }
    }

}
