package no.hvl.dat108.webshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Deltager {
	@Id
    @NotBlank
    @Pattern(regexp = "[0-9]{8}")
    @Column(unique = true)
    private String mobil;  // Mobilnummer (8 siffer)

    @NotBlank
    private String hash;    // Password hash

    @NotBlank
    private String salt;    // Password salt

    @NotBlank
    @Pattern(regexp = "^[A-Z][a-zA-ZæøåÆØÅ -]{1,19}")
    private String fornavn;  // Fornavn (2-20 tegn, første tegn stor bokstav)

    @NotBlank
    @Pattern(regexp = "^[A-Z][a-zA-ZæøåÆØÅ-]{1,19}")
    private String etternavn;  // Etternavn (2-20 tegn, første tegn stor bokstav)

    @NotBlank
    @Pattern(regexp = "^(mann|kvinne)$")
    private String kjonn;  // Kjønn ("mann" eller "kvinne")

    public Deltager() {
    }

    public Deltager(String mobil, String hash, String salt, String fornavn,
            String etternavn, String kjonn) {
        this.mobil = mobil;
        this.hash = hash;
        this.salt = salt;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
    }

    public String getMobil() { return mobil; }
    public void setMobil(String mobil) { this.mobil = mobil; }
    public String getHash() { return hash; }
    public void setHash(String hash) { this.hash = hash; }
    public String getSalt() { return salt; }
    public void setSalt(String salt) { this.salt = salt; }
    public String getFornavn() { return fornavn; }
    public void setFornavn(String fornavn) { this.fornavn = fornavn; }
    public String getEtternavn() { return etternavn; }
    public void setEtternavn(String etternavn) { this.etternavn = etternavn; }
    public String getKjonn() { return kjonn; }
    public void setKjonn(String kjonn) { this.kjonn = kjonn; }
}
