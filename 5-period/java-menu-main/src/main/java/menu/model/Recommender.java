package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.model.coach.Coach;
import menu.model.coach.Coaches;
import menu.model.coach.Inedible;

public class Recommender {

    private CategoryMaker categoryMaker;
    private List<String> categoryBox = new ArrayList<>();
    private final Map<String, List<String>> recommendMenuBox = new LinkedHashMap<>();

    public Recommender(final CategoryMaker categoryMaker) {
        this.categoryMaker = categoryMaker;
    }

    public Map<String, List<String>> run(Coaches coaches) {
        for (int i = 0; i < 5; i++) {
            recommend(coaches);
        }
        return recommendMenuBox;
    }

    public void recommend(Coaches coaches) {
        Map<String, Integer> box = new HashMap<>();
        final String category = getCategory(box);
        categoryBox.add(category);
        for (Coach coach : coaches.getCoaches()) {
            final String menu = recommendMenu(coach, category);
            final String name = coach.getName();
            recommendMenuBox.computeIfAbsent(name, k -> new ArrayList<>()).add(menu);
        }
    }

    private String getCategory(Map<String, Integer> box) {
        while (true) {
            final String category = categoryMaker.run().getCategory();
            if (box.getOrDefault(category, 0) < 2) {
                box.put(category, box.getOrDefault(category, 0) + 1);
                return category;
            }
        }

    }

    private String recommendMenu(Coach coach, String category) {
        final Inedible inedible = coach.getInedible();
        final List<String> dishes = Menu.findDishesByCategory(category);
        while (true) {
            final String recommendedMenu = Randoms.shuffle(dishes).getFirst();
            if (!inedible.contain(recommendedMenu)) {
                return recommendedMenu;
            }
        }
    }

    public List<String> getCategoryBox() {
        return categoryBox;
    }
}
