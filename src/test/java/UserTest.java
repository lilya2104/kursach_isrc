import org.example.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user = new User();

    @Test
    void test_emailValidation() {
        assertTrue(user.emailValidation("email@mail.ru"));

        assertThrows(IllegalArgumentException.class, () -> {
            user.emailValidation("mail///mail.ru");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            user.emailValidation("");
        });
    }
    @Test
    void test_cardValidation() {
        assertTrue(user.cardValidation("1234 1234 1234 1234"));

        assertThrows(IllegalArgumentException.class, () -> {
            user.cardValidation("1234 1234 123 12");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            user.cardValidation("");
        });
    }
    @Test
    void test_addCard() {
        assertTrue(user.addCard("0000000000000000"));
        assertTrue(user.addCard("1111 1111 1111 1111"));
        assertTrue(user.addCard("2222-2222-2222-2222"));

        assertThrows(IllegalArgumentException.class, () -> {
            user.cardValidation("1234 1234 123 12");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            user.cardValidation("");
        });
    }
    @Test
    void test_addCard_limit() {
        assertTrue(user.addCard("0000000000000000"));
        assertTrue(user.addCard("1111 1111 1111 1111"));
        assertTrue(user.addCard("2222-2222-2222-2222"));
        assertFalse(user.addCard("4444 4444 4444 4444"));
    }
}
