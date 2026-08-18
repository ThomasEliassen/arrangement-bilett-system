package no.hvl.dat108.webshop.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "billettkjop", uniqueConstraints = @UniqueConstraint(columnNames = "mobil"))
public class Billettkjop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "mobil", nullable = false)
    private Deltager deltager;

    @Enumerated(EnumType.STRING)
    private Billettype billettype;

    private int pris;
    private Instant kjopstidspunkt;

    protected Billettkjop() {
    }

    public Billettkjop(Deltager deltager, Billettype billettype) {
        this.deltager = deltager;
        this.billettype = billettype;
        this.pris = billettype.getPris();
        this.kjopstidspunkt = Instant.now();
    }

    public Long getId() { return id; }
    public Deltager getDeltager() { return deltager; }
    public Billettype getBillettype() { return billettype; }
    public int getPris() { return pris; }
    public Instant getKjopstidspunkt() { return kjopstidspunkt; }
}
