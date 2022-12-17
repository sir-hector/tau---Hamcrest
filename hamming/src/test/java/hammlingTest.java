import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class hammlingTest {

    public hammling hammling;

    @BeforeEach
    void setUp() {
        hammling = new hammling();
    }

    @AfterEach
    void tearDown() {
        hammling = null;
    }

    @Test
    void testSingleLetterIdenticalStrands() {
        assertThat(hammling.distance("A", "A")).isEqualTo(0);
    }

    @Test
    void testEmptyStrands() {
        assertThat(hammling.distance("", "")).isEqualTo(0);
    }


    @Test
    void testSingleLetterDifferentStrands() {
        assertThat(hammling.distance("G", "T")).isEqualTo(1);
    }

    @Test
    void testLongIdenticalStrands() {
        assertThat(hammling.distance("GGACTGAAATCTG", "GGACTGAAATCTG")).isEqualTo(0);
    }

    @Test
    void testLongDifferentStrands() {
        assertThat(hammling.distance("GGACGGATTCTG", "AGGACGGATTCT")).isEqualTo(9);
    }

    @Test
    void testDisallowFirstStrandLonger() {
        assertThatThrownBy(() -> {
            hammling.distance("AATG", "AAA");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("Different lengths");
    }

    @Test
    void testDisallowSecondStrandLonger() {
        assertThatThrownBy(() -> {
            hammling.distance("ATA", "AGTG");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("Different lengths");
    }

    @Test
    void testDisallowLeftEmptyStrand() {
        assertThatThrownBy(() -> {
            hammling.distance("", "A");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("Different lengths");
    }

    @Test
    void testDisallowRightEmptyStrand() {
        assertThatThrownBy(() -> {
            hammling.distance("A", "");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("Different lengths");
    }

}
