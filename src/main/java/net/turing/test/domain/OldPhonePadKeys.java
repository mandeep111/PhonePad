package net.turing.test.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OldPhonePadKeys {
    private final Map<Character, PhoneKey> keyMap;

    public OldPhonePadKeys(List<PhoneKey> keys) {
        this.keyMap = new HashMap<>();
        for (PhoneKey key : keys) {
            keyMap.put(key.digit(), key);
        }
    }

    public boolean contains(char c) {
        return keyMap.containsKey(c);
    }

    public PhoneKey getKey(char c) {
        return keyMap.get(c);
    }
}
