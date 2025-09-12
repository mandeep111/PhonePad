package net.turing.test.service;

import net.turing.test.domain.Key;
import net.turing.test.domain.OldPhonePadKeys;

public class InputProcessor {
    private final OldPhonePadKeys keys;

    public InputProcessor(OldPhonePadKeys keys) {
        this.keys = keys;
    }

    public String process(String input) {
        if (input == null || input.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '#', ' ' -> flushBuffer(result, buffer);
                case '*' -> handleBackspace(result, buffer);
                default -> {
                    if (Character.isDigit(c) && keys.contains(c)) {
                        handleDigit(result, buffer, c);
                    }
                }
            }
        }

        return result.toString();
    }

    private void handleBackspace(StringBuilder result, StringBuilder buffer) {
        flushBuffer(result, buffer);
        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1);
        }
    }

    private void handleDigit(StringBuilder result, StringBuilder buffer, char c) {
        if (!buffer.isEmpty() && buffer.charAt(0) != c) {
            flushBuffer(result, buffer);
        }
        buffer.append(c);
    }

    private void flushBuffer(StringBuilder result, StringBuilder buffer) {
        if (buffer.isEmpty()) return;
        Key key = keys.getKey(buffer.charAt(0));
        result.append(key.getLetter(buffer.length()));
        buffer.setLength(0);
    }
}
