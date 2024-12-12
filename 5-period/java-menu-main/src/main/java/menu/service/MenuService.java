package menu.service;

import java.util.List;
import menu.model.coach.Coach;
import menu.model.coach.Coaches;
import menu.model.coach.Inedible;
import menu.utils.StringParser;

public class MenuService {

    public Coaches generateCoaches(String coachName) {
        final List<String> coachNames = StringParser.parseToTokens(coachName, ",");
        return createCoaches(coachNames);
    }

    private Coaches createCoaches(final List<String> coachNames) {
        return new Coaches(createCoach(coachNames));
    }

    private static List<Coach> createCoach(final List<String> coachNames) {
        return coachNames.stream().map(Coach::new).toList();
    }


    public Inedible generateInedible(final String userInput) {
        if (userInput.isEmpty()) {
            return new Inedible(null);
        }
        return new Inedible(StringParser.parseToTokens(userInput, ","));
    }
}
