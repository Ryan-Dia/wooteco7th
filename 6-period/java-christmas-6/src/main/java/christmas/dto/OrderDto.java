package christmas.dto;

import christmas.model.Menu;
import christmas.model.order.Order;

public record OrderDto(Menu menu, int quantity) {
    public OrderDto(Order order) {
        this(order.getMenu(), order.getQuantity());
    }
}
