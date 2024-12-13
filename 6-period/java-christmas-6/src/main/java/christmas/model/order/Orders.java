package christmas.model.order;

import christmas.error.CIllegalArgumentException;
import christmas.error.ErrorMessages;
import java.util.HashSet;
import java.util.List;

public class Orders {
    private static final int MAX_ORDERS_COUNT = 20;
    private final List<Order> orders;
    private final int totalAmount;


    public Orders(final List<Order> orders) {
        validateOrderDuplication(orders);
        validateOnlyBeverage(orders);
        validateCount(orders);
        this.orders = orders;
        this.totalAmount = calculateTotalAmount();
    }

    private void validateCount(List<Order> orders) {
        final int sum = orders.stream()
                .mapToInt(Order::getQuantity)
                .sum();
        if (sum > MAX_ORDERS_COUNT) {
            throw new CIllegalArgumentException(ErrorMessages.INVALID_ORDER);
        }
    }

    private void validateOrderDuplication(List<Order> orders) {
        if (orders.size() != new HashSet<>(orders).size()) {
            throw new CIllegalArgumentException(ErrorMessages.INVALID_ORDER);
        }
    }

    private void validateOnlyBeverage(List<Order> orders) {
        if (isOnlyBeverage(orders)) {
            throw new CIllegalArgumentException(ErrorMessages.INVALID_ORDER);
        }
    }

    private boolean isOnlyBeverage(List<Order> orders) {
        final int ordersSize = orders.size();
        final long onlyBeverage = orders.stream().
                filter(Order::isBeverage)
                .count();
        return ordersSize == onlyBeverage;

    }

    private int calculateTotalAmount() {
        return orders.stream().mapToInt(this::calculate).sum();
    }

    private int calculate(Order order) {
        final int quantity = order.getQuantity();
        final int price = order.getMenu().getPrice();
        return quantity * price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
