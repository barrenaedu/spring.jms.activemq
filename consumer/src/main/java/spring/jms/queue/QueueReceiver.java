package spring.jms.queue;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.Message;
import javax.jms.MessageListener;

public class QueueReceiver implements MessageListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(QueueReceiver.class);

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ActiveMQTextMessage) {
                ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
                LOGGER.info("Receiving queue text message > {}", msg.getText());
            } else {
                LOGGER.info("Receiving queue unknown message type: {}", message.toString());
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

}
