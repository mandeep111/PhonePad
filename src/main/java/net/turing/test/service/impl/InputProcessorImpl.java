package net.turing.test.service.impl;

import net.turing.test.domain.OldPhonePadKeys;
import net.turing.test.service.interfaces.InputProcessor;
import net.turing.test.utils.PhonePadUtils;

public class InputProcessorImpl implements InputProcessor {
    private final OldPhonePadKeys oldPhonePadKeys;

    public InputProcessorImpl(OldPhonePadKeys oldPhonePadKeys) {
        this.oldPhonePadKeys = oldPhonePadKeys;
    }

    @Override
    public String process(String input) {
        if (input == null || input.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '#', ' ' -> PhonePadUtils.flushBuffer(result, buffer, oldPhonePadKeys);
                case '*' -> PhonePadUtils.handleBackspace(result, buffer, oldPhonePadKeys);
                default -> {
                    if (Character.isDigit(c) && this.oldPhonePadKeys.contains(c)) {
                        PhonePadUtils.handleDigit(result, buffer, c, oldPhonePadKeys);
                    }
                }
            }
        }

        return result.toString();
    }
}
