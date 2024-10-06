package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void 자동차_전진테스트() {
        Car car = new Car(0);
        car.move(4);
        assertThat(car).isEqualTo(new Car(1));
    }

    @Test
    public void 자동차_정지테스트() {
        Car car = new Car(0);
        car.move(3);
        assertThat(car).isEqualTo(new Car(0));
    }

}
