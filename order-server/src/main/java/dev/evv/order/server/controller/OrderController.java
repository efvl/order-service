package dev.evv.order.server.controller;

import dev.evv.order.client.model.Order;
import dev.evv.order.client.vo.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/order")
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private Environment environment;
    private Map<Long, Order> orders = new HashMap<>(){
        {
            put(333L, new Order(333L, 701L, 101L, LocalDate.of(2023, 03, 15),
                    LocalDate.of(2023, 03, 16), OrderStatus.CREATED));
            put(334L, new Order(334L, 701L, 102L, LocalDate.of(2023, 03, 15),
                    LocalDate.of(2023, 03, 16), OrderStatus.SUCCESS));
        }
    };

    @GetMapping("/all")
    public ResponseEntity<List<Order>> findAll(){
        String serverPort = environment.getProperty("local.server.port");
        logger.info("order server serverPort: " + serverPort);
        return ResponseEntity.ok(orders.values().stream().toList());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        orders.put(order.getId(), order);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteById(@PathVariable Long orderId){
        Optional<Order> deleted = Optional.ofNullable(orders.remove(orderId));
        return ResponseEntity.ok(String.format("order {id=%d} was deleted", deleted.orElse(new Order()).getId()));
    }

}
