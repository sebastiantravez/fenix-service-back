package com.project.fenix.entities.user;

import com.project.fenix.entities.BaseModel;
import com.project.fenix.enums.EnumStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseModel {
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private String avatar;
    private Boolean changePassword;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_rol", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles;

    public User(Long id, String userCreated, LocalDateTime createdAt, LocalDateTime updatedAt, EnumStatus status, String username, String password, String email, String avatar, Boolean changePassword, Set<Rol> roles) {
        super(id, userCreated, createdAt, updatedAt, status);
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.changePassword = changePassword;
        this.roles = roles;
    }
}
