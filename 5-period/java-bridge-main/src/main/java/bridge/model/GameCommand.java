package bridge.model;

import java.util.Arrays;
import java.util.Objects;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    GameCommand(final String expression) {
        this.command = expression;
    }

    public static GameCommand findByCommand(final String command) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> Objects.equals(gameCommand.command, command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] R 또는 Q만 입력가능합니다."));
    }
}
