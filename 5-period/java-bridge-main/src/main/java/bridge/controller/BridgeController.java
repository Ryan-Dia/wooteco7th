package bridge.controller;

import bridge.BridgeGame;
import bridge.InputView;
import bridge.OutputView;
import bridge.dto.UserBridgeDto;
import bridge.model.UserBridge;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private UserBridge userBridge;
    private int count = 0;

    public BridgeController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.userBridge = new UserBridge();
    }

    public void run() {
        OutputView.printStartMessage();
        final int bridgeSize = InputView.readBridgeSize();
        bridgeGame.setBridgeGame(bridgeSize);
        while(userBridge.getUp().size() < bridgeSize) {
            final String moving = InputView.readMoving();
            bridgeGame.move(moving, userBridge);
            OutputView.printMap(new UserBridgeDto(userBridge));
        }
        count++;
        if(bridgeGame.isFailed(userBridge)) {
            final String gameCommand = InputView.readGameCommand();
            if(gameCommand.equals("Q")) {
                // 게임 결과 출력
            }

        }else{
            OutputView.printResult("성공", count, new UserBridgeDto(userBridge));
        }

    }
}
