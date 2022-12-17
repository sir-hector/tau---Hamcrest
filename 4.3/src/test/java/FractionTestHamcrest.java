import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FractionTestHamcrest {

    @Test
    public void shouldReturnHalf(){
        assertThat(Fraction.of(1,2),is(Fraction.HALF));
    }

    @Test
    public void shouldReturnFull(){
        assertThat(Fraction.of(1,1),is(Fraction.FULL));
    }

    @Test
    public void fractionDoubleValueTest(){
        Fraction val = Fraction.of(1, 3);
        assertThat(val.doubleValue(), equalTo(Fraction.ONE_THIRD.doubleValue()));
    }

    @Test
    public void fractionMultiplyCorrectNumbersTest(){
        Fraction fr1 = Fraction.of(1, 4);
        assertThat(fr1.multiplyFractions(1,4), equalTo(0.0625));
    }

    @Test
    public void fractionMultiplyCorrectFractionsTest(){
        Fraction fr1 = Fraction.of(1, 4);
        Fraction fr2 = Fraction.of(1,4);
        assertThat(fr1.multiplyFractions(fr2), equalTo(0.0625));
    }

    @Test
    public void fractionMultiplyCorrectMinusNumbersTest(){
        Fraction fr1 = Fraction.of(1, -4);
        assertThat(fr1.multiplyFractions(1,4), is(-0.0625));
    }

    @Test
    public void fractionMultiplyCorrectMinusFractionsTest(){
        Fraction fr1 = Fraction.of(1, 4);
        Fraction fr2 = Fraction.of(1,-4);
        assertThat(fr1.multiplyFractions(fr2), equalTo(-0.0625));
    }

    @Test
    public void fractionDivideCorrectNumbersTest(){
        Fraction fr1 = Fraction.of(1, 4);
        assertThat(fr1.divideFractions(1,4), equalTo(1.));
    }

    @Test
    public void fractionDivideCorrectFractionsTest(){
        Fraction fr1 = Fraction.of(1, 4);
        Fraction fr2 = Fraction.of(1,4);
        assertThat(fr1.divideFractions(fr2), equalTo(1.));
    }

    @Test
    public void fractionDivideCorrectMinusNumbersTest(){
        Fraction fr1 = Fraction.of(1, -4);
        assertThat(fr1.divideFractions(1,4), equalTo(-1.));
    }

    @Test
    public void fractionDivideCorrectMinusFractionsTest(){
        Fraction fr1 = Fraction.of(1, 4);
        Fraction fr2 = Fraction.of(1,-4);
        assertThat(fr1.divideFractions(fr2), equalTo(-1.));
    }

}
