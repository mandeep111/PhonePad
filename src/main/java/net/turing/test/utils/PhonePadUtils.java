package net.turing.test.utils;

import net.turing.test.domain.OldPhonePadKeys;

public final class PhonePadUtils {

    private PhonePadUtils() {
        // prevent instantiation
    }

    public static void handleBackspace(StringBuilder result, StringBuilder buffer, OldPhonePadKeys keys) {
        flushBuffer(result, buffer, keys);
        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1);
        }
    }

    public static void handleDigit(StringBuilder result, StringBuilder buffer, char c, OldPhonePadKeys keys) {
        if (!buffer.isEmpty() && buffer.charAt(0) != c) {
            flushBuffer(result, buffer, keys);
        }
        buffer.append(c);
    }

    public static void flushBuffer(StringBuilder result, StringBuilder buffer, OldPhonePadKeys keys) {
        if (buffer.isEmpty()) return;
        char digit = buffer.charAt(0);
        String letters = keys.getKey(digit).letters();
        if (letters != null) {
            int index = (buffer.length() - 1) % letters.length();
            result.append(letters.charAt(index));
        }
        buffer.setLength(0);
    }
}
