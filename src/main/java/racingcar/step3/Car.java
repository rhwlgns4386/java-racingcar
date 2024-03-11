package racingcar.step3;

import racingcar.step3.move.MoveStrategy;

public class Car {

    private final int MOVE = 1;
    private final int STOP = 0;

    private final MoveStrategy moveStrategy;
    private int location;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public int getCurrentLocation() {
        return this.location;
    }

    public void move() {
        location += moveDistance();
    }

    private int moveDistance() {
        if (isMove()) {
            return MOVE;
        }
        return STOP;
    }

    private boolean isMove() {
        return moveStrategy.move();
    }
}
