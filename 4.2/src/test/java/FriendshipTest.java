import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class FriendshipTest {
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
        assertThat(friendships.getFriendsList("Karol")).hasSize(2);
    }

    @Test
    void testFriendshipContains() {
        assertThat(friendships.getFriendsList("Karol")).contains("Zbyszek", "Maciek");
    }

    @Test
    void testCreateInstance() {
        assertThat(friendships.getClass()).isEqualTo(Friendships.class);
    }

    @Test
    void testFriendshipContainOnlyOnce() {
        assertThat(friendships.getFriendsList("Karol")).containsOnlyOnce("Zbyszek");
    }

    @Test
    void testFriendshipFirstValue() {
        assertThat(friendships.getFriendsList("Karol").get(0)).isEqualTo("Zbyszek");
    }


}
