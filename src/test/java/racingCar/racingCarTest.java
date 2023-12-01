package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class racingCarTest {

    @Test
    @DisplayName("여러대의 자동차가 전진 조건에 따라서 시도횟수 만큼 움직인다.")
    public void 전진_조건에_따른_여러대_자동차_움직임() {
        Cars cars  = new Cars("aaa,bbb,ccc");
        cars.repeatMove(3, new RandomNumber() {
            @Override
            public List<Integer> generateRandomNumber(int tryNum) {
                return List.of(4,3,3);
            }
        });

        assertAll(
                () -> assertThat(cars.findCar("aaa").equals(new Car("aaa", 3))).isTrue(),
                () -> assertThat(cars.findCar("bbb").equals(new Car("bbb", 0))).isTrue(),
                () -> assertThat(cars.findCar("ccc").equals(new Car("ccc", 0))).isTrue()
        );
    }

    @Test
    @DisplayName("입력한 자동차 중 가장 많이 전진한 자동차 이름을 반환한다.")
    public void 가장_많이_전진한_자동차_이름_반환(){
        Cars cars = new Cars(Arrays.asList(
                new Car("pobi", 5),
                new Car("crong", 3),
                new Car("honux", 5)));

        RacingResult racingResult = new RacingResult(cars);
        List<String> winners = racingResult.returnWinnerCar();

        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactly("pobi","honux");
    }

    @Test
    @DisplayName("입력한 자동차 중 가장 많이 전진한 자동차의 전진 횟수를 반환한다.")
    public void 가장_많이_전진한_자동차_전진횟수_반환(){
        Cars cars = new Cars(Arrays.asList(
                new Car("pobi", 4),
                new Car("crong", 3),
                new Car("honux", 5)));

        RacingResult racingResult = new RacingResult(cars);
        assertThat(racingResult.getMaxForward()).isEqualTo(5);
    }

    @Test
    @DisplayName("입력한 여러대의 자동차 이름을 콤마 구분자로 구분하여 자동차 이름을 부여하고 0번 움직인 결과를 반환한다.")
    public void 자동차_경주_초기_설정(){
        String carNames = "pobi,crong,honux";

        Cars cars = new Cars(carNames);

        assertAll(
                () -> assertThat(cars.findCar("pobi").equals(new Car("pobi", 0))).isTrue(),
                () -> assertThat(cars.findCar("crong").equals(new Car("crong", 0))).isTrue(),
                () -> assertThat(cars.findCar("honux").equals(new Car("honux", 0))).isTrue()
        );
    }

    @Test
    @DisplayName("자동차 이름이 최대 길이를 초과할 경우 예외를 발생한다.")
    public void 자동차_이름_최대_길이_초과(){
        assertThatThrownBy(() -> {
            assertThat(new Car("abcedf",0));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름을 입력할 경우 해당 이름을 가진 자동차 객체를 생성한다.")
    public void 자동차_이름_부여(){
        Car car = new Car("pobi",0);
        assertThat(car.getCarName()).isEqualTo("pobi");
    }


    @Test
    @DisplayName("입력된 값에 따른 전진 결과를 반환한다.")
    public void 전진_결과_테스트(){
        Car car = new Car(0);

        car.moveCar(3);
        assertThat(car.equals(new Car(0))).isTrue();

        car.moveCar(4);
        assertThat(car.equals(new Car(1))).isTrue();
    }

}
