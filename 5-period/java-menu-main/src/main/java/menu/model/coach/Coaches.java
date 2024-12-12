package menu.model.coach;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(final List<Coach> coaches) {
        validateDuplication(coaches);
        this.coaches = coaches;
    }

    //TODO: List 중복검사 템플릿 만들기
    public void validateDuplication(List<Coach> coaches) {
        final long count = coaches.stream().distinct().count();
        if (count != coaches.size()) {
            throw new IllegalArgumentException("[ERROR] 코치이름은 중복을 허용하지 않습니다.");
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<String> getAllCoachName() {
        return coaches.stream().map(Coach::getName).toList();
    }
}
