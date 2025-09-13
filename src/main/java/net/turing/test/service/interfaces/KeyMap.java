package net.turing.test.service.interfaces;

import net.turing.test.domain.PhoneKey;

public interface KeyMap {
    boolean contains(char c);
    PhoneKey getKey(char c);
}
