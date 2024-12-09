package bridge.dto;

import bridge.model.UserBridge;
import java.util.List;

public record UserBridgeDto(List<String> up, List<String> down) {
    public UserBridgeDto(UserBridge userBridge) {
        this(userBridge.getUp(), userBridge.getDown());
    }
}
