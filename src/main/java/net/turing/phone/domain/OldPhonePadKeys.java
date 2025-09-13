package net.turing.phone.domain;

import net.turing.phone.service.interfaces.KeyMap;

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
