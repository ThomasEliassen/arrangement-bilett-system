package no.hvl.dat108.webshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import no.hvl.dat108.webshop.model.Billettype;

class BillettypeTest {

    @Test
    void findsTicketByPublicCode() {
        assertEquals(Billettype.STUDENT, Billettype.fraKode("student").orElseThrow());
        assertTrue(Billettype.fraKode("ukjent").isEmpty());
    }
}
