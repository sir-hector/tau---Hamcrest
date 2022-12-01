import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class StringOperationsTest {
    public StringOperations stringOperations;

    @BeforeEach
    void setUp() {
        stringOperations = new StringOperations();
    }

    @AfterEach
    void tearDown() {
        stringOperations = null;
    }

    
}
