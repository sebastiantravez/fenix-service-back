package com.project.fenix.entities;


import com.project.fenix.enums.EnumStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String userCreated = "SYSTEM_DEFAULT";

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private EnumStatus status = EnumStatus.ACT;

    public BaseModel(Long id) {
        this.id = id;
    }
}
