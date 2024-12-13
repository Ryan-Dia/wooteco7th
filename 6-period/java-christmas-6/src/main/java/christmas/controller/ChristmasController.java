package christmas.controller;

import christmas.dto.OrdersDto;
import christmas.error.CIllegalArgumentException;
import christmas.error.ErrorMessages;
import christmas.model.Badge;
import christmas.model.Event;
import christmas.model.Menu;
import christmas.model.VisitDay;
import christmas.model.order.Order;
import christmas.model.order.Orders;
import christmas.utils.LoopTemplate;
import christmas.utils.StringParser;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class ChristmasController {

    private final Event event;

    public ChristmasController(final Event event) {
        this.event = event;
    }

    public void run() {
        OutputView.printStartMessage();
        VisitDay visitDay = getVisitDay();
        Orders orders = getOrders();
        OutputView.printOrderMenu(new OrdersDto(orders), visitDay);
        OutputView.printTotalAmountBeforeDiscount(orders.getTotalAmount());
        OutputView.printPresentation(event.canPresent(orders.getTotalAmount()));
        OutputView.printBenefitInfo(event.getBenefit(visitDay, orders), orders.getTotalAmount());
        OutputView.printTotalBenefitAmount(event.totalBenefitAmount(visitDay, orders));
        OutputView.printTotalAmountAfterDiscount(orders.getTotalAmount(),
                event.totalAmountAfterDiscount(visitDay, orders));
        OutputView.printBadge(Badge.findByTotalBenefitAmount(event.totalBenefitAmount(visitDay, orders)));
    }

    private VisitDay getVisitDay() {
        return LoopTemplate.tryCatch(
                () -> new VisitDay(StringParser.parseToInt(InputView.readVisitDay(), ErrorMessages.INVALID_DATE)));
    }

    private Orders getOrders() {
        return LoopTemplate.tryCatch(() -> generateOrders(StringParser.parseToTokens(InputView.readOrder(), ",")));
    }

    private Orders generateOrders(List<String> inputOrders) {
        final List<Order> orders = inputOrders.stream().map(this::createOrder).toList();
        return new Orders(orders);
    }

    private Order createOrder(String inputOrderString) {
        final List<String> inputOrder = StringParser.parseToTokens(inputOrderString, "-");
        if (inputOrder.size() != 2) {
            throw new CIllegalArgumentException(ErrorMessages.INVALID_ORDER);
        }
        final Menu menu = Menu.findByMenuName(inputOrder.getFirst());
        final int quantity = StringParser.parseToInt(inputOrder.getLast(), ErrorMessages.INVALID_ORDER);
        return new Order(menu, quantity);
    }
}
