import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsDivisibleByHamcrest extends TypeSafeMatcher<Integer> {

    private Integer divider;

    public IsDivisibleByHamcrest(Integer divider) {
        this.divider = divider;
    }


    @Override
    protected boolean matchesSafely(Integer dividend) {
        if (divider == 0) {
            return false;
        }
        return ((dividend % divider) == 0);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("divisible by " + divider);
    }

    public static Matcher<Integer> divisibleBy(Integer divider) {
        return new IsDivisibleByHamcrest(divider);
    }
}