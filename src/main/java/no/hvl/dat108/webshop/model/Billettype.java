package no.hvl.dat108.webshop.model;

import java.util.Arrays;
import java.util.Optional;

public enum Billettype {
    STUDENT("student", "Student", 299),
    STANDARD("standard", "Standard", 499),
    PREMIUM("premium", "Premium", 799);

    private final String kode;
    private final String namn;
    private final int pris;

    Billettype(String kode, String namn, int pris) {
        this.kode = kode;
        this.namn = namn;
        this.pris = pris;
    }

    public String getKode() { return kode; }
    public String getNamn() { return namn; }
    public int getPris() { return pris; }

    public static Optional<Billettype> fraKode(String kode) {
        return Arrays.stream(values()).filter(type -> type.kode.equals(kode)).findFirst();
    }
}
