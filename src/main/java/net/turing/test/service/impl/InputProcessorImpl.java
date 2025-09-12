package net.turing.test.service.impl;

import net.turing.test.domain.OldPhonePadKeys;
import net.turing.test.service.interfaces.InputProcessor;
import net.turing.test.utils.PhonePadUtils;

public class InputProcessorImpl implements InputProcessor {
    private final OldPhonePadKeys keys;

    public InputProcessorImpl(OldPhonePadKeys keys) {
        this.keys = keys;
    }

    @Override
    public String process(String input) {
        if (input == null || input.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '#', ' ' -> PhonePadUtils.flushBuffer(result, buffer, keys);
                case '*' -> PhonePadUtils.handleBackspace(result, buffer, keys);
                default -> {
                    if (Character.isDigit(c) && this.keys.contains(c)) {
                        PhonePadUtils.handleDigit(result, buffer, c, keys);
                    }
                }
            }
        }

        return result.toString();
    }
}
