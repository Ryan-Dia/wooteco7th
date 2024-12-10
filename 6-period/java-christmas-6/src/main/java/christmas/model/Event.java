package christmas.model;

import christmas.dto.OrderMenusDto;
import christmas.utils.WeekdayChecker;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Event {
    private final VisitingDay visitingDay;
    private final int presentationDiscount;

    public Event(VisitingDay visitingDay, int presentationDiscount) {
        this.visitingDay = visitingDay;
        this.presentationDiscount = presentationDiscount;
    }

    public Discount getDiscount(OrderMenusDto orderMenusDto) {
        int christmasDiscount = getChristmasDiscount();
        Object[] weeklyDiscount = getWeeklyDiscount(orderMenusDto);
        int specialDiscount = getSpecialDiscount();
        if(weeklyDiscount[1] == "평일") {
            return new Discount(christmasDiscount, (int) weeklyDiscount[0], 0, presentationDiscount, specialDiscount);
        }
        return new Discount(christmasDiscount,0, (int) weeklyDiscount[0], presentationDiscount, specialDiscount);
    }

    public int getSpecialDiscount() {
        List<Integer> days = List.of(3,10,17, 24, 25, 31);
        if(days.contains(visitingDay.getVisitingDay())) {
            return 1000;
        }
        return 0;

    }

    private int getChristmasDiscount() {
        if(visitingDay.getVisitingDay() <= 25) {
            return (visitingDay.getVisitingDay() - 1) * 100 + 1000;
        }
        return 0;
    }

    private Object[] getWeeklyDiscount(OrderMenusDto orderMenusDto) {
        if(WeekdayChecker.check(visitingDay.getVisitingDay()).equals("평일")) {
            return new Object[]{ applyWeekDay(orderMenusDto), "평일"};
        }
        return new Object[]{ applyWeekEnd(orderMenusDto), "주말"};
    }



    private int applyWeekEnd(OrderMenusDto orderMenusDto) {
        final Map<String, Integer> order = orderMenusDto.orderMenus();
        final Map<String, Integer> mainMenuByMenuNames = Menus.findMainMenuByMenuNames(
                order.keySet().toArray(new String[0]));
        int discount = 0;
        for (Entry<String, Integer> mainMenu : mainMenuByMenuNames.entrySet()) {
            discount += order.get(mainMenu.getKey()) * 2023;
        }
        return discount;
    }

    private int applyWeekDay(OrderMenusDto orderMenusDto) {
        final Map<String, Integer> order = orderMenusDto.orderMenus();
        final Map<String, Integer> desserts = Menus.findDesserts(
                order.keySet().toArray(new String[0]));
        int discount = 0;
        for (Entry<String, Integer> mainMenu : desserts.entrySet()) {
            discount += order.get(mainMenu.getKey()) * 2023;
        }
        return discount;
    }
}
