package christmas.controller;

import christmas.error.ErrorMessages;
import christmas.model.VisitDay;
import christmas.utils.LoopTemplate;
import christmas.utils.StringParser;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {

    public void run() {
        OutputView.printStartMessage();
        VisitDay visitDay = getVisitDay();
    }

    private VisitDay getVisitDay() {
        return LoopTemplate.tryCatch(
                () -> new VisitDay(StringParser.parseToInt(InputView.readVisitDay(), ErrorMessages.INVALID_DATE)));
    }


}
