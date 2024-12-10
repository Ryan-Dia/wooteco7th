package christmas.controller;

import christmas.model.Order;
import christmas.utils.LoopTemplate;
import christmas.model.VisitingDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {

    public void run() {
        OutputView.printStartMessage();
        final VisitingDay visitingDay = getVisitingDay();
        Order order = getOrder();
    }

    private VisitingDay getVisitingDay() {
        return LoopTemplate.tryCatch(() -> new VisitingDay(InputView.readVisitingDay()));
    }

    private Order getOrder() {
        return LoopTemplate.tryCatch(() ->Order.of(InputView.readOrderMenus()));
    }
}
