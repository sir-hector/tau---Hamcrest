import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class test {

    @Test
    void testPalindrome() {
        assertThat("abba", isPalindromeHamcrest.isPalindrome());
    }
}
