import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestHamcrest {

    @Test
    void testPalindrome() {
        assertThat("abba", isPalindromeHamcrest.isPalindrome());
    }

    @Test
    void testPalindromeFalse() {
        assertThat("abbca", not(isPalindromeHamcrest.isPalindrome()));
    }

    @Test
    public void givenAnEvenInteger_whenDivisibleByTwo_thenCorrect() {
        assertThat(20,is(IsDivisibleByHamcrest.divisibleBy(2)));
    }

    @Test
    public void givenAnOddInteger_whenNotDivisibleByTwo_thenCorrect() {
        assertThat(13,is(not(IsDivisibleByHamcrest.divisibleBy(3))));
    }
}
