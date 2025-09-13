package net.turing.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OldPhonePadTest {
    @Test
    void testSingleKeyPress() {
        assertEquals("E", OldPhonePad.process("33#"));
    }

    @Test
    void testFalseSingleKeyPress() {
        assertNotEquals("D", OldPhonePad.process("33#"));
    }

    @Test
    void testBackspace() {
        assertEquals("B", OldPhonePad.process("227*#"));
    }

    @Test
    void testHello() {
        assertEquals("HELLO", OldPhonePad.process("4433555 555666#"));
    }

    @Test
    void testTuring() {
        assertEquals("TURING", OldPhonePad.process("8 88777444666*664#"));
    }

    @Test
    void testEmptyInput() {
        assertEquals("", OldPhonePad.process(""));
    }

    @Test
    void testOnlyHash() {
        assertEquals("", OldPhonePad.process("#"));
    }

    @Test
    void testMultipleBackspaces() {
        assertEquals("A", OldPhonePad.process("22*2#")); // B -> backspace -> A
    }

    @Test
    void testConsecutiveSpaces() {
        assertEquals("AA", OldPhonePad.process("2 2#")); // pause allows separate A's
    }
}
