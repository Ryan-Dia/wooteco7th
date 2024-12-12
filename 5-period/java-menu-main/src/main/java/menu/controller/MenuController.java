package menu.controller;

import menu.dto.RecommendedMenu;
import menu.model.CategoryMaker;
import menu.model.Recommender;
import menu.model.coach.Coaches;
import menu.model.coach.Inedible;
import menu.service.MenuService;
import menu.utils.LoopTemplate;
import menu.utils.RandomNumberGenerator;
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
        final RecommendedMenu recommendedMenu = getRecommendedMenu(coaches);
        OutputView.printResult(recommendedMenu);
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

    private RecommendedMenu getRecommendedMenu(Coaches coaches) {
        final Recommender recommender = new Recommender(new CategoryMaker(new RandomNumberGenerator()));
        return new RecommendedMenu(recommender.run(coaches), recommender.getCategoryBox());
    }


}
