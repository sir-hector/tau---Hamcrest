import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FractionTestAssertJ {

    @Test
    public void testThrowException(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Fraction.of(1, 0);
        });
    }


    @Test
    public void fractionHALFTest(){
        Fraction val = Fraction.of(1, 2);
        assertThat(val).isEqualTo(Fraction.HALF);
    }

    @Test
    public void fractionFULLTest(){
        Fraction val = Fraction.of(1, 1);
        assertThat(val).isEqualTo(Fraction.FULL);
    }

    @Test
    public void fractionDoubleValueTest(){
        Fraction val = Fraction.of(1, 3);
        assertThat(val.doubleValue()).isEqualTo(Fraction.ONE_THIRD.doubleValue());
    }

    @Test
    public void fractionMultiplyCorrectNumbersTest(){
        Fraction fr1 = Fraction.of(1, 4);
        assertThat(fr1.multiplyFractions(1,4)).isGreaterThanOrEqualTo(0.0625);
    }

    @Test
    public void fractionMultiplyCorrectFractionsTest(){
        Fraction fr1 = Fraction.of(1, 4);
        Fraction fr2 = Fraction.of(1,4);
        assertThat(fr1.multiplyFractions(fr2)).isLessThanOrEqualTo(0.0625);
    }

    @Test
    public void fractionMultiplyCorrectMinusNumbersTest(){
        Fraction fr1 = Fraction.of(1, -4);
        assertThat(fr1.multiplyFractions(1,4)).isEqualByComparingTo(-0.0625);
    }

    @Test
    public void fractionMultiplyCorrectMinusFractionsTest(){
        Fraction fr1 = Fraction.of(1, 4);
        Fraction fr2 = Fraction.of(1,-4);
        assertThat(fr1.multiplyFractions(fr2)).isEqualTo(-0.0625);
    }

    @Test
    public void fractionDivideCorrectNumbersTest(){
        Fraction fr1 = Fraction.of(1, 4);
        assertThat(fr1.divideFractions(1,4)).isEqualTo(1.);
    }

    @Test
    public void fractionDivideCorrectFractionsTest(){
        Fraction fr1 = Fraction.of(1, 4);
        Fraction fr2 = Fraction.of(1,4);
        assertThat(fr1.divideFractions(fr2)).isLessThanOrEqualTo((1.));
    }

    @Test
    public void fractionDivideCorrectMinusNumbersTest(){
        Fraction fr1 = Fraction.of(1, -4);
        assertThat(fr1.divideFractions(1,4)).isGreaterThanOrEqualTo(-1.);
    }

    @Test
    public void fractionDivideCorrectMinusFractionsTest(){
        Fraction fr1 = Fraction.of(1, 4);
        Fraction fr2 = Fraction.of(1,-4);
        assertThat(fr1.divideFractions(fr2)).isEqualTo((-1.));
    }


}
