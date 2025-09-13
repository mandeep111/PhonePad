package net.turing.test;

import net.turing.test.component.BufferProcessor;
import net.turing.test.domain.PhoneKey;
import net.turing.test.service.interfaces.KeyMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BufferProcessorTest {

    private BufferProcessor bufferProcessor;
    private StringBuilder result;
    private StringBuilder buffer;
    private TestKeyMap keyMap;

    @BeforeEach
    void setUp() {
        bufferProcessor = new BufferProcessor();
        result = new StringBuilder();
        buffer = new StringBuilder();
        keyMap = new TestKeyMap();
    }

    @Test
    void testFlushBuffer_EmptyBuffer_DoesNothing() {
        bufferProcessor.flushBuffer(result, buffer, keyMap);
        assertEquals("", result.toString());
        assertEquals("", buffer.toString());
    }

    @Test
    void testFlushBuffer_SingleDigit_AppendsFirstLetter() {
        buffer.append("2");
        bufferProcessor.flushBuffer(result, buffer, keyMap);
        assertEquals("A", result.toString());
        assertEquals("", buffer.toString());
    }

    @Test
    void testFlushBuffer_DoubleDigit_AppendsSecondLetter() {
        buffer.append("33");
        bufferProcessor.flushBuffer(result, buffer, keyMap);
        assertEquals("E", result.toString());
        assertEquals("", buffer.toString());
    }

    @Test
    void testFlushBuffer_TripleDigit_AppendsThirdLetter() {
        buffer.append("444");
        bufferProcessor.flushBuffer(result, buffer, keyMap);
        assertEquals("I", result.toString());
        assertEquals("", buffer.toString());
    }

    @Test
    void testFlushBuffer_CyclesBackToFirstLetter() {
        buffer.append("2222");
        bufferProcessor.flushBuffer(result, buffer, keyMap);
        assertEquals("A", result.toString());
        assertEquals("", buffer.toString());
    }

    @Test
    void testFlushBuffer_NullPhoneKey_DoesNothing() {
        buffer.append("9");
        bufferProcessor.flushBuffer(result, buffer, keyMap);
        assertEquals("", result.toString());
        assertEquals("", buffer.toString());
    }

    @Test
    void testHandleDigit_SameDigit_AppendsToBuffer() {
        buffer.append("2");
        bufferProcessor.handleDigit(result, buffer, '2', keyMap);
        assertEquals("22", buffer.toString());
        assertEquals("", result.toString());
    }

    @Test
    void testHandleDigit_DifferentDigit_FlushesAndAppendsNew() {
        buffer.append("22");
        bufferProcessor.handleDigit(result, buffer, '3', keyMap);
        assertEquals("B", result.toString());
        assertEquals("3", buffer.toString());
    }

    @Test
    void testHandleBackspace_WithResult_FlushesAndRemovesLastChar() {
        result.append("HELLO");
        buffer.append("77");
        bufferProcessor.handleBackspace(result, buffer, keyMap);
        assertEquals("HELLO", result.toString());
        assertEquals("", buffer.toString());
    }

    @Test
    void testSequentialOperations() {
        // Type "22" -> "B"
        bufferProcessor.handleDigit(result, buffer, '2', keyMap);
        bufferProcessor.handleDigit(result, buffer, '2', keyMap);
        bufferProcessor.flushBuffer(result, buffer, keyMap);

        assertEquals("B", result.toString());
        assertEquals("", buffer.toString());

        // Type "333" -> "F"
        bufferProcessor.handleDigit(result, buffer, '3', keyMap);
        bufferProcessor.handleDigit(result, buffer, '3', keyMap);
        bufferProcessor.handleDigit(result, buffer, '3', keyMap);
        bufferProcessor.flushBuffer(result, buffer, keyMap);

        assertEquals("BF", result.toString());
        assertEquals("", buffer.toString());
    }

    // Test implementation of KeyMap
    private static class TestKeyMap implements KeyMap {
        @Override
        public boolean contains(char c) {
            return c >= '2' && c <= '8';
        }

        @Override
        public PhoneKey getKey(char c) {
            return switch (c) {
                case '2' -> new PhoneKey('2', "ABC");
                case '3' -> new PhoneKey('3', "DEF");
                case '4' -> new PhoneKey('4', "GHI");
                case '5' -> new PhoneKey('5', "JKL");
                case '6' -> new PhoneKey('6', "MNO");
                case '7' -> new PhoneKey('7', "PQRS");
                case '8' -> new PhoneKey('8', "TUV");
                default -> null;
            };
        }
    }
}