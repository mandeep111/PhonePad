package net.turing.test.factory;

import net.turing.test.enums.PhonePadType;
import net.turing.test.service.impl.OldPhonePad;
import net.turing.test.service.interfaces.PhonePad;

public class PhonePadFactory {
    private PhonePadFactory() {}

    public static PhonePad createPhonePad(PhonePadType type) {
        return switch (type) {
            case OLD_PHONE_PAD -> new OldPhonePad();
            // can add more types here in the future
        };
    }
}
