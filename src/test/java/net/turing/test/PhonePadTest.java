package net.turing.test;

import static org.junit.jupiter.api.Assertions.*;

import net.turing.test.service.OldPhonePad;
import net.turing.test.service.interfaces.PhonePad;
import org.junit.jupiter.api.Test;

class PhonePadTest {
    private final PhonePad pad = new OldPhonePad();

    @Test
    void testSingleKeyPress() {
       assertEquals("E", pad.processInput("33#"));
    }

    @Test
    void testFalseSingleKeyPress() {
        assertNotEquals("D", pad.processInput("33#"));
    }

    @Test
    void testBackspace() {
        assertEquals("B", pad.processInput("227*#"));
    }

    @Test
    void testHello() {
        assertEquals("HELLO", pad.processInput("4433555 555666#"));
    }

    @Test
    void testTuring() {
        assertEquals("TURING", pad.processInput("8 88777444666*664#"));
    }

    @Test
    void testEmptyInput() {
        assertEquals("", pad.processInput(""));
    }

    @Test
    void testOnlyHash() {
        assertEquals("", pad.processInput("#"));
    }

    @Test
    void testMultipleBackspaces() {
        assertEquals("A", pad.processInput("22*2#"));
    }

    @Test
    void testConsecutiveSpaces() {
        assertEquals("AA", pad.processInput("2 2#"));
    }
}
