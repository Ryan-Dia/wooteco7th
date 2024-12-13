package christmas.model.order;

import christmas.error.ErrorMessages;
import christmas.model.Menu;
import christmas.model.MenuType;
import christmas.utils.NumberValidator;

public class Order {
    public static final int MIN_QUANTITY = 1;
    public static final int MAX_QUANTITY = 100;
    private final Menu menu;
    private final int quantity;

    public Order(final Menu menu, final int quantity) {
        validateQuantity(quantity);
        this.menu = menu;
        this.quantity = quantity;
    }

    private void validateQuantity(int quantity) {
        NumberValidator.validateRange(quantity, MIN_QUANTITY, MAX_QUANTITY, ErrorMessages.INVALID_ORDER);
    }

    public boolean hasDesiredMenuType(MenuType menuType) {
        return this.menu.getMenuType() == menuType;
    }

    public boolean isBeverage() {
        return menu.getMenuType() == MenuType.BEVERAGE;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
