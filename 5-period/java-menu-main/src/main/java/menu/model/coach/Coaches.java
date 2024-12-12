package menu.model.coach;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(final List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
