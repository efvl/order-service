package dev.evv.order.client.model;

import dev.evv.order.client.vo.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {

    private UUID eventId = UUID.randomUUID();
    private LocalDateTime localDateTime = LocalDateTime.now();
    private Order order;
    private OrderStatus orderStatus;

}
