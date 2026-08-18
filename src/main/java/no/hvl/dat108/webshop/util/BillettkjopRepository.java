package no.hvl.dat108.webshop.util;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.dat108.webshop.model.Billettkjop;

public interface BillettkjopRepository extends JpaRepository<Billettkjop, Long> {

    Optional<Billettkjop> findByDeltagerMobil(String mobil);

    boolean existsByDeltagerMobil(String mobil);

    List<Billettkjop> findAllByOrderByDeltagerFornavnAscDeltagerEtternavnAsc();
}
