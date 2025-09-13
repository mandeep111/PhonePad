package net.turing.test.service.impl;

import net.turing.test.service.interfaces.InputProcessor;
import net.turing.test.service.interfaces.KeyMap;
import net.turing.test.service.interfaces.ProcessingRules;
import net.turing.test.component.BufferProcessor;

public class ConfigurableInputProcessor implements InputProcessor {
    private final KeyMap keyMap;
    private final ProcessingRules rules;
    private final BufferProcessor bufferProcessor;

    public ConfigurableInputProcessor(KeyMap keyMap, ProcessingRules rules, BufferProcessor bufferProcessor) {
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
