package com.project.fenix.repository;

import com.project.fenix.entities.user.Rol;
import com.project.fenix.enums.EnumRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByName(EnumRol name);
}