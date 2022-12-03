import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class StringOperationTestAssertJ {
    public StringOperations stringOperations;

    @BeforeEach
    void setUp() {
        stringOperations = new StringOperations();
    }

    @AfterEach
    void tearDown() {
        stringOperations = null;
    }

    @Test
    @DisplayName("Test reverse method - simple word")
    void testReverseSimpleWord() {
        assertThat(stringOperations.reverse("ABC")).hasSize(3);
    }

    @Test
    @DisplayName("Test reverse method - sentence")
    void TestReverseSentence() {
        String reverseString = stringOperations.reverse("Ala ma kota");
        assertThat(reverseString).startsWith("atok");
    }

    @Test
    @DisplayName("Test reverse method - sentence")
    void TestReverseSentenceEnds() {
        String reverseString = stringOperations.reverse("Ala ma kota");
        assertThat(reverseString).endsWith("alA");

    }

    @Test
    @DisplayName("Test Contact method")
    void TestContactMethod() {
        String concatString = stringOperations.concat("", "");
        assertThat(concatString).isNull();
    }

    @Test
    @DisplayName("Test Contact method - contain")
    void TestContactMethodContainString() {
        String concatString = stringOperations.concat("ala", "ma");
        assertThat(concatString).containsSequence("am");
    }
}
