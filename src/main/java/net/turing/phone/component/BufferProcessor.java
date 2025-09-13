package net.turing.phone.component;

import net.turing.phone.domain.PhoneKey;
import net.turing.phone.service.interfaces.KeyMap;

public class BufferProcessor {
    public void handleBackspace(StringBuilder result, StringBuilder buffer, KeyMap keyMap) {
        flushBuffer(result, buffer, keyMap);
        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1);
        }
    }

    public void handleDigit(StringBuilder result, StringBuilder buffer, char c, KeyMap keyMap) {
        if (!buffer.isEmpty() && buffer.charAt(0) != c) {
            flushBuffer(result, buffer, keyMap);
        }
        buffer.append(c);
    }

    public void flushBuffer(StringBuilder result, StringBuilder buffer, KeyMap keyMap) {
        if (buffer.isEmpty()) return;

        char digit = buffer.charAt(0);
        PhoneKey phoneKey = keyMap.getKey(digit);

        if (phoneKey != null && phoneKey.letters() != null) {
            String letters = phoneKey.letters();
            int index = (buffer.length() - 1) % letters.length();
            result.append(letters.charAt(index));
        }

        buffer.setLength(0);
    }
}
