package no.hvl.dat108.webshop.model;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PaameldingForm {

    @NotBlank(message = "Fornamn må fyllast ut")
    @Pattern(regexp = "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ -]{1,19}$",
            message = "Fornamn må starte med stor bokstav og ha 2–20 teikn")
    private String fornavn;

    @NotBlank(message = "Etternamn må fyllast ut")
    @Pattern(regexp = "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ -]{1,19}$",
            message = "Etternamn må starte med stor bokstav og ha 2–20 teikn")
    private String etternavn;

    @Pattern(regexp = "^[0-9]{8}$", message = "Mobilnummeret må ha 8 siffer")
    private String mobil;

    @NotBlank(message = "Passord må fyllast ut")
    @Size(min = 8, max = 72, message = "Passordet må ha 8–72 teikn")
    private String passord;

    @NotBlank(message = "Passordet må gjentakast")
    private String passordRepetert;

    @Pattern(regexp = "^(mann|kvinne)$", message = "Vel kjønn")
    private String kjonn;

    @AssertTrue(message = "Passorda må vere like")
    public boolean isPassordLike() {
        return passord != null && passord.equals(passordRepetert);
    }

    public String getFornavn() { return fornavn; }
    public void setFornavn(String fornavn) { this.fornavn = fornavn; }
    public String getEtternavn() { return etternavn; }
    public void setEtternavn(String etternavn) { this.etternavn = etternavn; }
    public String getMobil() { return mobil; }
    public void setMobil(String mobil) { this.mobil = mobil; }
    public String getPassord() { return passord; }
    public void setPassord(String passord) { this.passord = passord; }
    public String getPassordRepetert() { return passordRepetert; }
    public void setPassordRepetert(String passordRepetert) { this.passordRepetert = passordRepetert; }
    public String getKjonn() { return kjonn; }
    public void setKjonn(String kjonn) { this.kjonn = kjonn; }
}
