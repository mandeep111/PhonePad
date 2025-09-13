package net.turing.test.domain;

import net.turing.test.service.interfaces.KeyMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OldPhonePadKeys implements KeyMap {
    private final Map<Character, PhoneKey> keyMap;

    public OldPhonePadKeys(List<PhoneKey> keys) {
        this.keyMap = new HashMap<>();
        for (PhoneKey key : keys) {
            keyMap.put(key.digit(), key);
        }
    }

    @Override
    public boolean contains(char c) {
        return keyMap.containsKey(c);
    }

    @Override
    public PhoneKey getKey(char c) {
        return keyMap.get(c);
    }
}
