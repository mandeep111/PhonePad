package net.turing.test;

import net.turing.test.service.OldPhonePad;
import net.turing.test.service.interfaces.PhonePad;

public class Main {
    public static void main(String[] args) {
        PhonePad pad = new OldPhonePad();

        System.out.println(pad.processInput("33#"));               // E
        System.out.println(pad.processInput("227*#"));             // B
        System.out.println(pad.processInput("4433555 555666#"));   // HELLO
        System.out.println(pad.processInput("8 88777444666*664#")); // TURING
    }
}
