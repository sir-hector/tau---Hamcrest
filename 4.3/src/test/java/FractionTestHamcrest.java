
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FractionTestHamcrest {

    @Test
    public void shouldReturnHalf(){
        assertThat(Fraction.of(1,2),is(Fraction.HALF));
    }

}
