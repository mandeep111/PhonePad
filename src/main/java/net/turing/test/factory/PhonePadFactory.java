package net.turing.test.factory;

import net.turing.test.enums.PhonePadType;
import net.turing.test.service.impl.OldPhonePadImpl;
import net.turing.test.service.interfaces.PhonePad;

public class PhonePadFactory {
    private PhonePadFactory() {
    }

    public static PhonePad createPhonePad(PhonePadType type) {
        if (type.equals(PhonePadType.OLD_PHONE_PAD)) {
            return new OldPhonePadImpl();
        }
        // can add more types here in the future
        throw new IllegalArgumentException("PhonePadType cannot be null");
    }
}
