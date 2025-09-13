package net.turing.phone.factory;

import net.turing.phone.domain.OldPhonePadKeys;
import net.turing.phone.domain.PhoneKey;
import net.turing.phone.enums.KeyboardType;

import java.util.List;
import java.util.Objects;

public class PhoneKeyFactory {
    private PhoneKeyFactory() {
        // prevent instantiation
    }

    public static OldPhonePadKeys english(KeyboardType type) {
        if (Objects.requireNonNull(type) == KeyboardType.LETTERS) {
            List<PhoneKey> keys = List.of(
                    new PhoneKey('1', ""),
                    new PhoneKey('2', "ABC"),
                    new PhoneKey('3', "DEF"),
                    new PhoneKey('4', "GHI"),
                    new PhoneKey('5', "JKL"),
                    new PhoneKey('6', "MNO"),
                    new PhoneKey('7', "PQRS"),
                    new PhoneKey('8', "TUV"),
                    new PhoneKey('9', "WXYZ"),
                    new PhoneKey('0', " ")
            );
            return new OldPhonePadKeys(keys);
        }
        throw new IllegalArgumentException("Unsupported keyboard type: " + type);
    }
}
