import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void test_numberValid() {
        assertTrue(Main.numberValidation("8 (999) 777 66-55"));
        assertTrue(Main.numberValidation("+7 (999) 777 66-55"));
        assertTrue(Main.numberValidation("89997776655"));
        assertTrue(Main.numberValidation("8(999)7776655"));
        assertFalse(Main.numberValidation("9 111 2222 22"));
        assertFalse(Main.numberValidation("9080798"));
        assertFalse(Main.numberValidation(""));
    }
    @Test
    void test_numberRedact() {
        assertEquals("9997776655", Main.numberRedact("8 (999) 777 66-55"));
        assertEquals("9997776655", Main.numberRedact("+7 (999) 777 66-55"));
        assertEquals("9997776655", Main.numberRedact("89997776655"));
        assertEquals("9997776655", Main.numberRedact("8(999)7776655"));
        assertNull(Main.numberRedact("9 111 2222 22"));
        assertNull(Main.numberRedact("9080798"));
        assertNull(Main.numberRedact(""));
    }
    @Test
    void test_numSmsValid() {
        assertTrue(Main.numSmsValid("0987"));
        assertFalse(Main.numSmsValid("0000"));
        assertFalse(Main.numSmsValid(""));
    }
}
