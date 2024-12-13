package christmas.model.order;

import christmas.error.CIllegalArgumentException;
import christmas.error.ErrorMessages;
import java.util.HashSet;
import java.util.List;

public class Orders {
    public static final int MAX_ORDERS_COUNT = 20;
    public final List<Order> orders;

    public Orders(final List<Order> orders) {
        validateOrderDuplication(orders);
        validateOnlyBeverage(orders);
        validateCount(orders);
        this.orders = orders;
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

    public List<Order> getOrders() {
        return orders;
    }
}
