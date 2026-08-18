package no.hvl.dat108.webshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import no.hvl.dat108.webshop.util.PasswordUtil;

class PasswordUtilTest {

    @Test
    void samePasswordAndSaltProduceSameHash() {
        String salt = PasswordUtil.generateSalt();
        assertEquals(PasswordUtil.hash("eit-trygt-passord", salt),
                PasswordUtil.hash("eit-trygt-passord", salt));
    }

    @Test
    void differentSaltsProduceDifferentHashes() {
        String firstSalt = PasswordUtil.generateSalt();
        String secondSalt = PasswordUtil.generateSalt();
        assertNotEquals(PasswordUtil.hash("eit-trygt-passord", firstSalt),
                PasswordUtil.hash("eit-trygt-passord", secondSalt));
    }

    @Test
    void verifiesCorrectPasswordAndRejectsWrongPassword() {
        String salt = PasswordUtil.generateSalt();
        String hash = PasswordUtil.hash("korrekt-passord", salt);

        assertTrue(PasswordUtil.matches("korrekt-passord", salt, hash));
        assertFalse(PasswordUtil.matches("feil-passord", salt, hash));
        assertFalse(PasswordUtil.matches(null, salt, hash));
    }
}
