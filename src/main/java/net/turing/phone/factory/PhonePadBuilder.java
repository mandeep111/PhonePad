package net.turing.phone.factory;


import net.turing.phone.enums.KeyboardType;
import net.turing.phone.enums.LanguageType;
import net.turing.phone.service.impl.InputProcessorImpl;
import net.turing.phone.service.impl.OldPhonePadRules;
import net.turing.phone.service.interfaces.BasePhonePad;
import net.turing.phone.service.interfaces.KeyMap;
import net.turing.phone.service.interfaces.PhonePad;
import net.turing.phone.service.interfaces.ProcessingRules;
import net.turing.phone.component.BufferProcessor;

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