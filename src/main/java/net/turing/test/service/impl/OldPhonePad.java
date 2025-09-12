package net.turing.test.service.impl;

import net.turing.test.domain.OldPhonePadKeys;
import net.turing.test.component.InputProcessor;
import net.turing.test.service.interfaces.PhonePad;

public class OldPhonePad implements PhonePad {

    private final InputProcessor processor;

    public OldPhonePad() {
        this.processor = new InputProcessor(new OldPhonePadKeys());
    }

    @Override
    public String processInput(String input) {
        return this.processor.process(input);
    }
}
