package dev.evv.order.client.model;

import dev.evv.order.client.vo.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private Long roomId;
    private LocalDate from;
    private LocalDate to;
    private OrderStatus status;

}
