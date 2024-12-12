package menu.model.coach;

import java.util.List;
import menu.error.CIllegalArgumentException;
import menu.error.ErrorMessages;
import menu.model.Menu;

public class Inedible {
    public static final int INEDIBLE_MAX = 2;
    List<String> inedible;

    public Inedible(final List<String> inedible) {
        validateCount(inedible);
        validateEdible(inedible);
        validateDuplication(inedible);
        this.inedible = inedible;
    }

    private void validateCount(List<String> inedible) {
        if (inedible.size() > INEDIBLE_MAX) {
            throw new CIllegalArgumentException(ErrorMessages.INEDIBLE_COUNT);
        }
    }

    private void validateEdible(List<String> inedible) {
        if (!inedible.stream().allMatch(Menu::hasMenu)) {
            throw new CIllegalArgumentException(ErrorMessages.INVALID_INEDIBLE);
        }
    }

    private void validateDuplication(List<String> inedible) {
        final long count = inedible.stream().distinct().count();
        if (count != inedible.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 메뉴를 작성할 수 없습니다.");
        }
    }
}
