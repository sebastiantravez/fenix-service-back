package com.project.fenix.entities.user;

import com.project.fenix.entities.BaseModel;
import com.project.fenix.enums.EnumRol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "roles")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rol extends BaseModel {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumRol name;

    @ManyToMany
    @JoinTable(
            name = "rol_permissions",
            joinColumns = @JoinColumn(
                    name = "rol_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "permission_id", referencedColumnName = "id"))
    private Set<Permission> permissions;
}
