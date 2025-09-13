package net.turing.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OldPhonePadUtilityTest {
    @Test
    void testSingleKeyPress() {
        assertEquals("E", OldPhonePadUtility.process("33#"));
    }

    @Test
    void testFalseSingleKeyPress() {
        assertNotEquals("D", OldPhonePadUtility.process("33#"));
    }

    @Test
    void testBackspace() {
        assertEquals("B", OldPhonePadUtility.process("227*#"));
    }

    @Test
    void testHello() {
        assertEquals("HELLO", OldPhonePadUtility.process("4433555 555666#"));
    }

    @Test
    void testTuring() {
        assertEquals("TURING", OldPhonePadUtility.process("8 88777444666*664#"));
    }

    @Test
    void testEmptyInput() {
        assertEquals("", OldPhonePadUtility.process(""));
    }

    @Test
    void testOnlyHash() {
        assertEquals("", OldPhonePadUtility.process("#"));
    }

    @Test
    void testMultipleBackspaces() {
        assertEquals("A", OldPhonePadUtility.process("22*2#")); // B -> backspace -> A
    }

    @Test
    void testConsecutiveSpaces() {
        assertEquals("AA", OldPhonePadUtility.process("2 2#")); // pause allows separate A's
    }
}
