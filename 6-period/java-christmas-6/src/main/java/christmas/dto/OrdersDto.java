package christmas.dto;

import christmas.model.order.Orders;
import java.util.List;

public record OrdersDto(List<OrderDto> orders) {
    public OrdersDto(Orders orders) {
        this(orders.getOrders().stream().map(OrderDto::new).toList());
    }
}
