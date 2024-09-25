package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("콜론구분자 더하기")
    public void sumWithColonDelimiter(){
        Calculator calculator=new Calculator();
        assertThat(calculator.sum("1:2")).isEqualTo(3);
    }
}
