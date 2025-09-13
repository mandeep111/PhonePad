package net.turing.phone.service.impl;

import net.turing.phone.service.interfaces.InputProcessor;
import net.turing.phone.service.interfaces.KeyMap;
import net.turing.phone.service.interfaces.ProcessingRules;
import net.turing.phone.component.BufferProcessor;

public class InputProcessorImpl implements InputProcessor {
    private final KeyMap keyMap;
    private final ProcessingRules rules;
    private final BufferProcessor bufferProcessor;

    public InputProcessorImpl(KeyMap keyMap, ProcessingRules rules, BufferProcessor bufferProcessor) {
        this.keyMap = keyMap;
        this.rules = rules;
        this.bufferProcessor = bufferProcessor;
    }

    @Override
    public String process(String input) {
        if (input == null || input.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (rules.isFlushCharacter(c)) {
                bufferProcessor.flushBuffer(result, buffer, keyMap);
            } else if (rules.isBackspaceCharacter(c)) {
                bufferProcessor.handleBackspace(result, buffer, keyMap);
            } else if (rules.isValidDigit(c, keyMap)) {
                bufferProcessor.handleDigit(result, buffer, c, keyMap);
            }
        }

        return result.toString();
    }
}
