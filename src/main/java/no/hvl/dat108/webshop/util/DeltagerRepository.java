package no.hvl.dat108.webshop.util;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.hvl.dat108.webshop.model.Deltager;

@Repository
public interface DeltagerRepository extends JpaRepository<Deltager, String> {

    List<Deltager> findAllByOrderByFornavnAscEtternavnAsc();
}
