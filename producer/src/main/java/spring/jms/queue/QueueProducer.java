package spring.jms.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

@Component
public class QueueProducer {
    private final static Logger LOGGER = LoggerFactory.getLogger(QueueProducer.class);

    private JmsOperations jmsOperations;

    @Autowired
    public QueueProducer(@Qualifier("jmsTemplateQueue") JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    public void produce() throws InterruptedException {
        LOGGER.info("Producing 10 queue messages...");
        for (int i = 1; i <= 10; i++) {
            LOGGER.info("Sending message: {}", i);
            jmsOperations.convertAndSend("Message queue: " + i);
            Thread.sleep(1000);
        }
    }

}
