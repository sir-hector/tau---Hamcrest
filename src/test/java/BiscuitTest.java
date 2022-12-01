import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BiscuitTest {

    @Test
    public void testEquals(){
        String theBiscuit = new String("Ginger");
        String myBiscuit = new String("Ginger");
        assertThat(theBiscuit, equalTo(myBiscuit));
    }
}
