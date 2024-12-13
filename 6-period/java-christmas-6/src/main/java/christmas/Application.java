package christmas;

import christmas.controller.ChristmasController;
import christmas.model.Event;

public class Application {
    public static void main(String[] args) {
        ChristmasController christmasController = new ChristmasController(new Event());
        christmasController.run();
    }
}
