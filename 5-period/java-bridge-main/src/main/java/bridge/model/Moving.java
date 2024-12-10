package bridge.model;

import java.util.Arrays;
import java.util.Objects;

public enum Moving {
    UP("U"),
    DOWN("D");

    private final String moving;

    Moving(final String moving) {
        this.moving = moving;
    }

    public String getMoving() {
        return moving;
    }

    public static Moving findByMoving(String input) {
        return Arrays.stream(Moving.values())
                .filter(v-> Objects.equals(v.getMoving(), input))
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException("[ERROR] U 또는 D만 입력할 수 있습니다."));
    }

    public boolean isUp() {
            return this == UP;
    }
}
