package net.turing.phone.service.impl;

import net.turing.phone.service.interfaces.KeyMap;
import net.turing.phone.service.interfaces.ProcessingRules;

public class OldPhonePadRules implements ProcessingRules {
    @Override
    public boolean isFlushCharacter(char c) {
        return c == '#' || c == ' ';
    }

    @Override
    public boolean isBackspaceCharacter(char c) {
        return c == '*';
    }

    @Override
    public boolean isValidDigit(char c, KeyMap keyMap) {
        return Character.isDigit(c) && keyMap.contains(c);
    }
}
