package net.turing.test.factory;


import net.turing.test.enums.KeyboardType;
import net.turing.test.enums.LanguageType;
import net.turing.test.service.impl.*;
import net.turing.test.service.interfaces.BasePhonePad;
import net.turing.test.service.interfaces.KeyMap;
import net.turing.test.service.interfaces.PhonePad;
import net.turing.test.service.interfaces.ProcessingRules;
import net.turing.test.component.BufferProcessor;

public class PhonePadBuilder {
    private KeyboardType keyboardType = KeyboardType.LETTERS;
    private LanguageType languageType = LanguageType.ENGLISH;
    private ProcessingRules rules = new OldPhonePadRules();
    private final BufferProcessor bufferProcessor = new BufferProcessor();

    public PhonePadBuilder withKeyboard(KeyboardType type) {
        this.keyboardType = type;
        return this;
    }

    public PhonePadBuilder withRules(ProcessingRules rules) {
        this.rules = rules;
        return this;
    }

    public PhonePadBuilder withLanguage(LanguageType type) {
        this.languageType = type;
        return this;
    }

    public PhonePad build() {
        KeyMap keyMap = switch (languageType) {
            case ENGLISH -> PhoneKeyFactory.english(keyboardType);
        };
        InputProcessorImpl processor = new InputProcessorImpl(keyMap, rules, bufferProcessor);
        return new ConfigurablePhonePad(processor);
    }

    private static class ConfigurablePhonePad extends BasePhonePad {
        public ConfigurablePhonePad(InputProcessorImpl processor) {
            super(processor);
        }
    }
}