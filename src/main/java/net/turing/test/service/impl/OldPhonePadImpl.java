package net.turing.test.service.impl;

import net.turing.test.domain.OldPhonePadKeys;
import net.turing.test.enums.KeyboardType;
import net.turing.test.factory.PhoneKeyFactory;
import net.turing.test.service.interfaces.InputProcessor;
import net.turing.test.service.interfaces.PhonePad;

public class OldPhonePadImpl implements PhonePad {

    private final InputProcessor processor;

    public OldPhonePadImpl() {
        OldPhonePadKeys keyMap = PhoneKeyFactory.english(KeyboardType.LETTERS);
        this.processor = new InputProcessorImpl(keyMap);
    }

    @Override
    public String processInput(String input) {
        return this.processor.process(input);
    }
}
