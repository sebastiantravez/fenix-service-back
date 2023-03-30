package com.project.fenix.repository;

import com.project.fenix.entities.company.Subsidiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubsidiaryRepository extends JpaRepository<Subsidiary, Long> {
    Optional<Subsidiary> findByEmissionPointAndEstablishmentPoint(String emissionPoint, String establishmentPoint);
}
