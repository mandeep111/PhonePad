package net.turing.phone.service.interfaces;

import net.turing.phone.domain.PhoneKey;

public interface KeyMap {
    boolean contains(char c);
    PhoneKey getKey(char c);
}
