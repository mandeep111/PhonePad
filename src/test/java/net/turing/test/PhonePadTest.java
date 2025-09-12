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

    @Test
    void testHello() {
        assertEquals("HELLO", PhonePad.oldPhonePad("4433555 555666#"));
    }

    @Test
    void testTuring() {
        assertEquals("TURING", PhonePad.oldPhonePad("8 88777444666*664#"));
    }

    @Test
    void testEmptyInput() {
        assertEquals("", PhonePad.oldPhonePad(""));
    }

    @Test
    void testOnlyHash() {
        assertEquals("", PhonePad.oldPhonePad("#"));
    }

    @Test
    void testMultipleBackspaces() {
        assertEquals("A", PhonePad.oldPhonePad("22*2#"));
    }

    @Test
    void testConsecutiveSpaces() {
        assertEquals("AA", PhonePad.oldPhonePad("2 2#"));
    }
}
