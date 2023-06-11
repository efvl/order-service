package dev.evv.order.server.service;

import dev.evv.order.client.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Value("${app.kafka.producer.topic}")
    private String topic;

    private KafkaTemplate<String, String> kafkaTemplate;

    public OrderServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String message) {
        logger.info("message sent: {}", message);
        kafkaTemplate.send(topic, message);
    }

    @Override
    public void sendOrderEvent(OrderEvent orderEvent) {

    }
}
