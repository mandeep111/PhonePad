package net.turing.phone;

import java.util.*;

//*
// Utility class to process old phone keypad input
// */
public class OldPhonePadUtility {

    private OldPhonePadUtility() {}

    private static final Map<Character, String> KEYPAD = Map.of(
            '2', "ABC",
            '3', "DEF",
            '4', "GHI",
            '5', "JKL",
            '6', "MNO",
            '7', "PQRS",
            '8', "TUV",
            '9', "WXYZ"
    );

    public static String process(String input) {
        if (input == null || input.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '#', ' ' -> flushBuffer(result, buffer);
                case '*' -> handleBackspace(result, buffer);
                default -> {
                    if (Character.isDigit(c) && KEYPAD.containsKey(c)) {
                        handleDigit(result, buffer, c);
                    }
                }
            }
        }

        return result.toString();
    }

    private static void handleBackspace(StringBuilder result, StringBuilder buffer) {
        flushBuffer(result, buffer);
        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1);
        }
    }

    private static void handleDigit(StringBuilder result, StringBuilder buffer, char c) {
        if (!buffer.isEmpty() && buffer.charAt(0) != c) {
            flushBuffer(result, buffer);
        }
        buffer.append(c);
    }

    private static void flushBuffer(StringBuilder result, StringBuilder buffer) {
        if (buffer.isEmpty()) return;

        char key = buffer.charAt(0);
        int count = buffer.length();
        String letters = KEYPAD.get(key);
        char letter = letters.charAt((count - 1) % letters.length());
        result.append(letter);

        buffer.setLength(0);
    }
}

