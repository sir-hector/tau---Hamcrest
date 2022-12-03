
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FriendshipTestHamcrest {
    public Friendships friendships;

    @BeforeEach
    void setUp() {
        friendships = new Friendships();
        friendships.makeFriends("Karol", "Zbyszek");
        friendships.makeFriends("Karol", "Maciek");

    }

    @AfterEach
    void tearDown() {
        friendships = null;
    }

    @Test
    void testFriendshipSize() {
        assertThat(friendships.getFriendsList("Karol"), hasSize(2));
    }

    @Test
    void testFriendshipContains() {
        assertThat(friendships.getFriendsList("Karol"),contains("Zbyszek", "Maciek"));
    }

    @Test
    void testCreateInstance() {
        assertThat(friendships.getClass(),is(Friendships.class));
    }

    @Test
    void testFriendshipContainOnlyOnce() {
        assertThat(friendships.getFriendsList("Karol"),contains("Zbyszek", "Maciek"));
    }

    @Test
    void testFriendshipFirstValue() {
        assertThat(friendships.getFriendsList("Karol").get(0),is("Zbyszek"));
    }


}
