package racinggame;

import racinggame.random.DefaultRandomNumberGenerator;
import racinggame.view.OutPutView;
import racinggame.domain.RacingGame;
import racinggame.domain.SnapShotStore.SnapShot;
import racinggame.dto.InputDto;
import racinggame.view.InputView;

public class RacingMain {

    public static void main(String[] args) {
        InputDto read = InputView.readCount();
        RacingGame racingGame = new RacingGame(read.getRepeatCount(),read.getCarCount());
        SnapShot snapShot = racingGame.start(new DefaultRandomNumberGenerator());
        OutPutView.render(snapShot);
    }

}
