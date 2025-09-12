package net.turing.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PhonePadTest {
    @Test
    void testSingleKeyPress() {
       assertEquals("E", PhonePad.oldPhonePad("33#"));
    }

    @Test
    void testBackspace() {
        assertEquals("B", PhonePad.oldPhonePad("227*#"));
    }
}
