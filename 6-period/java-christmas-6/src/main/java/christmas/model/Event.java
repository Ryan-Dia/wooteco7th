package christmas.model;

import christmas.model.order.Orders;
import christmas.utils.WeekdayChecker;

public class Event {


    public static final int MIN_DAY_CHRISTMAS_DISCOUNT = 1;
    public static final int MAX_DAY_CHRISTMAS_DISCOUNT = 25;
    public static final int PRESENTATION_CRITRION = 120_000;
    public static final int CHRISTMAS_BASE_DISCOUNT_AMOUNT = 1_000;
    private static final int WEEK_DISCOUNT_AMOUNT = 2_300;

    public boolean canPresent(int totalAmount) {
        return totalAmount >= PRESENTATION_CRITRION;
    }

    public Benefit getBenefit(VisitDay visitDay, Orders orders) {
        final int christmasDiscount = calculateChristmasDiscount(visitDay.getVisitDay());
        final int weekDiscount = calculateWeekDiscount(visitDay, orders);
        final boolean canPresent = canPresent(orders.getTotalAmount());
        final boolean isWeekday = WeekdayChecker.isWeekday(visitDay.getVisitDay());
        final boolean isSpecialDay = isSpecialDay(visitDay);
        return new Benefit(christmasDiscount, weekDiscount, canPresent, isWeekday, isSpecialDay);
    }

    public int calculateChristmasDiscount(int visitDay) {
        if (canChristmasDiscount(visitDay)) {
            return visitDay * 100 + CHRISTMAS_BASE_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private static boolean canChristmasDiscount(final int visitDay) {
        return visitDay >= MIN_DAY_CHRISTMAS_DISCOUNT && visitDay <= MAX_DAY_CHRISTMAS_DISCOUNT;
    }

    public int calculateWeekDiscount(final VisitDay visitDay, Orders orders) {
        if (visitDay.isWeekDay()) {
            return orders.getOrders().stream()
                    .filter(order -> order.getMenu().getMenuType() == MenuType.DESSERT)
                    .mapToInt(order -> order.getQuantity() * WEEK_DISCOUNT_AMOUNT)
                    .sum();
        }
        return orders.getOrders().stream()
                .filter(order -> order.getMenu().getMenuType() == MenuType.MAIN)
                .mapToInt(order -> order.getQuantity() * WEEK_DISCOUNT_AMOUNT)
                .sum();
    }

    private boolean isSpecialDay(VisitDay visitDay) {
        return visitDay.isSpecialDay();
    }


}


