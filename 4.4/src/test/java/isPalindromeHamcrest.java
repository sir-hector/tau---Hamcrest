import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class isPalindromeHamcrest extends TypeSafeMatcher<String> {
    @Override
    protected boolean matchesSafely(String item) {
        String clean = item.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("palindrome check");
    }

    public static Matcher<String> isPalindrome() {
        return new isPalindromeHamcrest();
    }
}
