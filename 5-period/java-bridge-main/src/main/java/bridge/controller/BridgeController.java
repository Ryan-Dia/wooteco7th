package bridge.controller;

import bridge.BridgeGame;
import bridge.InputView;
import bridge.OutputView;
import bridge.dto.UserBridgeDto;
import bridge.model.GameCommand;
import bridge.model.Moving;
import bridge.model.UserBridge;
import bridge.utils.LoopTemplate;

public class BridgeController {

    private final BridgeGame bridgeGame;

    public BridgeController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void setUp() {
        OutputView.printStartMessage();
        final int bridgeSize = getBridgeSize();
        bridgeGame.setBridgeGame(bridgeSize);
        run(bridgeSize);
    }

    private int getBridgeSize() {
        return LoopTemplate.tryCatch(InputView::readBridgeSize);
    }

    private void run(int bridgeSize) {
        bridgeGame.setUserBridge();
        processGame(bridgeSize);
        final UserBridge userBridge = bridgeGame.getUserBridge();

        if(bridgeGame.isFailed(userBridge)) {
            final String gameCommand = getGameCommand();
            if(bridgeGame.isRetry(GameCommand.findByCommand(gameCommand))) {
                bridgeGame.retry();
                run(bridgeSize);
            }
            OutputView.printResult("실패", bridgeGame.getCount(), new UserBridgeDto(userBridge));
            return;
        }
        OutputView.printResult("성공", bridgeGame.getCount(), new UserBridgeDto(userBridge));
    }

    private String getGameCommand() {
        return LoopTemplate.tryCatch(InputView::readGameCommand);
    }

    private void processGame(final int bridgeSize) {
        final UserBridge userBridge = bridgeGame.getUserBridge();
        while(userBridge.getUp().size() < bridgeSize) {
            final Moving moving = getMoving();
            bridgeGame.move(moving, userBridge);
            OutputView.printMap(new UserBridgeDto(userBridge));
        }
    }

    private Moving getMoving() {
        final String moving = LoopTemplate.tryCatch(InputView::readMoving);
        return Moving.findByMoving(moving);
    }

}
