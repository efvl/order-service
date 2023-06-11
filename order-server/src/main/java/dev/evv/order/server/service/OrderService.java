package dev.evv.order.server.service;

import dev.evv.order.client.model.OrderEvent;

public interface OrderService {

    void send(String message);

    void sendOrderEvent(OrderEvent orderEvent);

}
