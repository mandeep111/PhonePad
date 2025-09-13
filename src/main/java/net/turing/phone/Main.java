package net.turing.phone;

import net.turing.phone.enums.KeyboardType;
import net.turing.phone.factory.PhonePadBuilder;
import net.turing.phone.service.impl.OldPhonePadRules;
import net.turing.phone.service.interfaces.PhonePad;

// Just for manual testing
public class Main {
    public static void main(String[] args) {
        PhonePad pad = new PhonePadBuilder()
                .withKeyboard(KeyboardType.LETTERS)
                .withRules(new OldPhonePadRules())
                .build();
        System.out.println(pad.processInput("33#"));               // E
        System.out.println(pad.processInput("227*#"));             // B
        System.out.println(pad.processInput("4433555 555666#"));   // HELLO
        System.out.println(pad.processInput("8 88777444666*664#")); // TURING
        System.out.println(pad.processInput(""));                  // (empty string)
        System.out.println(pad.processInput("#"));                 // (empty string)
        System.out.println(pad.processInput("22*2#"));             // A
        System.out.println(pad.processInput("2 2#"));              // AA


    }
}
