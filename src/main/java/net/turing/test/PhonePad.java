package net.turing.test;

import java.util.Map;

public class PhonePad {
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

    public static String oldPhonePad(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c == '#') {
                flushBuffer(result, buffer);
                break;
            } else if (c == '*') {
                flushBuffer(result, buffer);
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1); // backspace
                }
            } else if (c == ' ') {
                flushBuffer(result, buffer); // pause ends current character
            } else if (Character.isDigit(c) && KEYPAD.containsKey(c)) {
                if (buffer.length() > 0 && buffer.charAt(0) != c) {
                    flushBuffer(result, buffer);
                }
                buffer.append(c);
            }
        }

        return result.toString();
    }

    private static void flushBuffer(StringBuilder result, StringBuilder buffer) {
        if (buffer.isEmpty()) return;

        char key = buffer.charAt(0);
        int count = buffer.length();
        String letters = KEYPAD.get(key);

        // cycle through characters based on count
        char letter = letters.charAt((count - 1) % letters.length());
        result.append(letter);

        buffer.setLength(0); // clear buffer
    }
}
