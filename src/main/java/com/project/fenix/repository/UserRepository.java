package com.project.fenix.repository;

import com.project.fenix.entities.user.User;
import com.project.fenix.enums.EnumStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findOneByEmailOrUsername(String email, String username);
    Long countByStatus(EnumStatus status);
}
