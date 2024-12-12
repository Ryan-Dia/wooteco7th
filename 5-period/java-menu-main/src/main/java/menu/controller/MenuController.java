package menu.controller;

import menu.model.coach.Coaches;
import menu.model.coach.Inedible;
import menu.service.MenuService;
import menu.utils.LoopTemplate;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    public final MenuService menuService;

    public MenuController(final MenuService menuService) {
        this.menuService = menuService;
    }

    public void run() {
        OutputView.printStartMessage();
        Coaches coaches = getCoaches();
        setInedible(coaches);
    }

    private Coaches getCoaches() {
        return LoopTemplate.tryCatch(() -> menuService.generateCoaches(InputView.readCoachName()));
    }

    private void setInedible(Coaches coaches) {
        coaches.getCoaches().forEach(coach -> coach.setInedible(getInedible(coach.getName())));
    }

    private Inedible getInedible(String coachName) {
        return LoopTemplate.tryCatch(() -> menuService.generateInedible(InputView.readInedible(coachName)));
    }


}
