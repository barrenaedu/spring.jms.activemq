package spring.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import spring.jms.queue.QueueProducer;
import spring.jms.topic.TopicPublisher;

@SpringBootApplication
@ImportResource("classpath:spring-config.xml")
public class Application {

    public static void main (String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        // Start producing queue messages
        QueueProducer queueProducer = context.getBean(QueueProducer.class);
        queueProducer.produce();

        // Start publishing topic messages
        TopicPublisher topicPublisher = context.getBean(TopicPublisher.class);
        topicPublisher.produce();
    }

}
