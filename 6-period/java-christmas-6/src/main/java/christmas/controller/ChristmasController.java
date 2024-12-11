package christmas.controller;

import christmas.dto.OrderMenusDto;
import christmas.dto.PresentationDto;
import christmas.model.Badge;
import christmas.model.Event;
import christmas.model.Order;
import christmas.model.Presentation;
import christmas.utils.LoopTemplate;
import christmas.model.VisitingDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {

    public void run() {
        OutputView.printStartMessage();
        final VisitingDay visitingDay = getVisitingDay();
        Order order = getOrder();
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        OutputView.printOrderMenus(new OrderMenusDto(order.getOrder()));
        OutputView.printTotalAmount(order.getTotalAmount());
        final Presentation presentation = new Presentation(order.getTotalAmount());
        OutputView.printPresentation(new PresentationDto(presentation));
        Event event = new Event(visitingDay, presentation.getBenefitAmount());
        OutputView.printBenefit(event.getDiscount(new OrderMenusDto(order.getOrder())));
        OutputView.printTotalBenefitAmount(event.getDiscount(new OrderMenusDto(order.getOrder())).totalBenefitAmount());
        OutputView.printTotalAmountAfterDiscount(order.getTotalAmount(), event.getDiscount(new OrderMenusDto(order.getOrder())).totalBenefitAmountWithoutPresentation());
        OutputView.printBadge(Badge.getBadge(event.getDiscount(new OrderMenusDto(order.getOrder())).totalBenefitAmount()));
    }

    private VisitingDay getVisitingDay() {
        return LoopTemplate.tryCatch(() -> new VisitingDay(InputView.readVisitingDay()));
    }

    private Order getOrder() {
        return LoopTemplate.tryCatch(() ->Order.of(InputView.readOrderMenus()));
    }
}
